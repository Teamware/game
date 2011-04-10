package game.client.domain.listeners;

import game.client.domain.Tickable;
import game.client.domain.WorldObject;

public class TickNotifier extends AbstractNotifier<Tickable> {

	public void notifyTick() {
		notify(new NotifyClosure<Tickable>() {

			@Override
			public void notify(Tickable listener) {
				listener.tick();
			}
		});
	}

	public void addIfTickable(WorldObject object) {
		if(object instanceof Tickable) {
			add((Tickable)object);
		}
	}

}
