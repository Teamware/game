package game.client;

import game.client.domain.WorldObject;

import com.google.gwt.http.client.Request;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GameService</code>.
 */
public interface GameServiceAsync {
	
	Request listenNewObjects(String input, AsyncCallback<WorldObject> callback)
			throws IllegalArgumentException;

	void add(WorldObject object, AsyncCallback<Void> callback);

	void hello(AsyncCallback<Void> callback);
}
