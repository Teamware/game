package game.server;

import game.client.GameService;
import game.client.domain.WorldObject;

import java.util.ArrayList;
import java.util.List;

import org.gwt_websocketrpc.server.ConnectionLostException;
import org.gwt_websocketrpc.server.PushCallback;
import org.gwt_websocketrpc.server.ResponseSentLater;
import org.gwt_websocketrpc.server.WsRpcServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GameServiceImpl extends WsRpcServlet implements
 GameService {
	
    private List<PushCallback<WorldObject>> callbacks = new ArrayList<PushCallback<WorldObject>>();


	public WorldObject listenNewObjects(String input) throws IllegalArgumentException {
		callbacks.add(this.getPushCallback(WorldObject.class));
		throw new ResponseSentLater();
	}

	@Override
	public void add(final WorldObject object) {
		
		new Thread( new Runnable() {
			
			@Override
			public void run() {
				ArrayList<PushCallback<WorldObject>> disconnected = new ArrayList<PushCallback<WorldObject>>();
				for (PushCallback<WorldObject> callback : callbacks) {
					try {
						callback.onSuccess(object);
					} catch(ConnectionLostException e) {
						disconnected.add(callback);
					}
				}
				callbacks.removeAll(disconnected);
			}
		}).start();
	}

	@Override
	public void hello() {
		System.out.println("Hello!!!");
	}

}
