package game.client.presenter;

import game.client.domain.LigthHouse;
import game.client.domain.Robot;
import game.client.domain.World;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class WorldPresenterTest {

	private IMocksControl control;
	@SuppressWarnings("unused")
	private WorldPresenter presenter;
	private WorldView view;
	private World world;

	@Before
	public void setup() {
		control = EasyMock.createControl();
		view = control.createMock(WorldView.class);
		world = new World();
		presenter = new WorldPresenterImpl(view, world);
	}
	
	@After
	public void teardown() {
		control.verify();		
	}

	@Test
	public void whenANewObjectIsCreatedOnTheWorld() {
		Robot robot = new Robot(0, 0);
		view.add(robot);
		
		control.replay();
		world.add(robot);
	}
	
	@Test
	public void whenTheWorldTicks() {
		LigthHouse ligthhouse = new LigthHouse(0, 0);

		view.add(ligthhouse);
		
		control.replay();
		world.add(ligthhouse);
		world.tick();
	}
}
