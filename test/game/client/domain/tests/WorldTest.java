package game.client.domain.tests;

import game.client.domain.Robot;
import game.client.domain.World;
import game.client.domain.WorldObject;
import game.client.domain.listeners.WorldListener;
import junit.framework.Assert;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.Before;
import org.junit.Test;


public class WorldTest {
	
	private World world;
	private IMocksControl control;

	@Before
	public void setup() {
		world = new World();
		control = EasyMock.createControl();
	}

	@Test
	public void addingAnObject() {
		WorldObject robot = new Robot(0,0);
		WorldListener listener = control.createMock(WorldListener.class);		
		world.add(listener);
		listener.onNewObject(world, robot);
		control.replay();
		world.add(robot);
		Assert.assertEquals(1, world.getObjects().size());
		control.verify();
	}
	
}
