package game.client.domain;

import game.client.domain.listeners.TickNotifier;
import game.client.domain.listeners.WorldListener;
import game.client.domain.listeners.WorldNotifier;


public class World {
	
	private WorldObjects _objects = new WorldObjects();
	private WorldNotifier _notifier = new WorldNotifier(this);
	private TickNotifier _tickNotifier = new TickNotifier();


	public WorldObjects getObjects() {
		return _objects;
	}

	public void add(WorldListener listener) {
		_notifier.add(listener);
	}

	public void add(WorldObject object) {
		_objects.add(object);
		_notifier.notifyNewObject(object);
		_tickNotifier.addIfTickable(object);		
	}

	public void tick() {
		_tickNotifier.notifyTick();
	}
}
