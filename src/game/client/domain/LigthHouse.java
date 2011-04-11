package game.client.domain;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.GwtTransient;

import game.client.domain.listeners.ChangeListener;
import game.client.domain.listeners.ChangeNotifier;


public class LigthHouse implements WorldObject, Tickable, Serializable {

	private static final long serialVersionUID = 1L;
	private int x=0;
	private int y=0;

	@GwtTransient
	private ChangeNotifier notifier = new ChangeNotifier();

	public LigthHouse() {
		this.x = 0;
		this.y = 0;
	}
	
	public LigthHouse(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void add(ChangeListener listener) {
		notifier.add(listener);
	}

	@Override
	public void tick() {
		notifier.notifyChange();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
