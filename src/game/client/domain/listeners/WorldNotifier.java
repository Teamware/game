package game.client.domain.listeners;

import game.client.domain.World;
import game.client.domain.WorldObject;

public class WorldNotifier extends AbstractNotifier<WorldListener> {
	
	private final World world;

	public WorldNotifier(World world) {
		this.world = world;
	}

	public void notifyNewObject(final WorldObject object) {
		notify(new NotifyClosure<WorldListener>() {

			@Override
			public void notify(WorldListener listener) {
				listener.onNewObject(world, object);
			}
		});
	}

}
