package game.client.domain;

import game.client.domain.listeners.ChangeListener;
import game.client.domain.listeners.ChangeNotifier;


public class LigthHouse implements WorldObject, Tickable {

	private int x=0;
	private int y=0;
	private ChangeNotifier notifier = new ChangeNotifier();

	public LigthHouse(int x, int y) {
		this.x = x;
		this.y = y;
		tick();
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
