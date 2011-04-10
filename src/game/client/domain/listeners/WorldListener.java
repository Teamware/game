package game.client.domain.listeners;

import game.client.domain.World;
import game.client.domain.WorldObject;

public interface WorldListener {

	void onNewObject(World world, WorldObject object);

}
