package game.client.domain.listeners;

import java.util.ArrayList;
import java.util.List;

public class AbstractNotifier<T> {

	private ArrayList<T> _listeners = new ArrayList<T>();

	public void add(T listener) {
		_listeners.add(listener);
	}
	
	public void remove(T listener) {
		_listeners.remove(listener);
	}
	
	protected List<T> listeners() {
		return _listeners;
	}
	
	public void notify(NotifyClosure<T> closure) {
		for (T listener : listeners()) {
			closure.notify(listener);
		}				
	}
	
	public interface NotifyClosure<T> {
		void notify(T listener);
	}
}
