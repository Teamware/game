package game.client;

import game.client.domain.WorldObject;

import org.gwt_websocketrpc.client.ServerPushEnabled;
import org.gwt_websocketrpc.shared.WsRpcService;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("gameservice")
public interface GameService extends WsRpcService {

	@ServerPushEnabled
	WorldObject listenNewObjects(String name) throws IllegalArgumentException;
	
	void add(WorldObject object);
	
	void hello();
}
