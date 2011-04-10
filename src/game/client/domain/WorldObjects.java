package game.client.domain;

import java.util.ArrayList;

public class WorldObjects {
	
	private ArrayList<WorldObject> objects = new ArrayList<WorldObject>();

	public int size() {
		return objects.size();
	}

	public void add(WorldObject object) {
		objects.add(object);
	}

}
