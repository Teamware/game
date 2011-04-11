package game.client.presenter;

import game.client.domain.LigthHouse;
import game.client.domain.Robot;
import game.client.domain.World;
import game.client.domain.WorldObject;
import game.client.domain.listeners.WorldListener;


public class WorldPresenterImpl implements WorldPresenter {

	private final WorldView view;
	private final World world;

	public WorldPresenterImpl(WorldView view, World world) {
		this.view = view;
		this.world = world;
		this.world.add( new WorldListener() {
			
			@Override
			public void onNewObject(World world, WorldObject object) {
				newObjectOnWorld(object);
			}
		});
		/*
		this.world.add(new Robot(250, 200));
		this.world.add(new LigthHouse(100, 150));
		/**/
	}

	protected void newObjectOnWorld(WorldObject object) {
		view.add(object);
	}

	/* (non-Javadoc)
	 * @see jogo.client.presenter.WorldPresenter#up()
	 */
	@Override
	public void up() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see jogo.client.presenter.WorldPresenter#down()
	 */
	@Override
	public void down() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see jogo.client.presenter.WorldPresenter#left()
	 */
	@Override
	public void left() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see jogo.client.presenter.WorldPresenter#rigth()
	 */
	@Override
	public void rigth() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see jogo.client.presenter.WorldPresenter#createNewRobot()
	 */
	@Override
	public void createNewRobot() {
		world.add(new Robot(randInt(900), randInt(600)));
	}

	private int randInt(int i) {
		return (int)(i*Math.random());
	}

	/* (non-Javadoc)
	 * @see jogo.client.presenter.WorldPresenter#createNewLigthHouse()
	 */
	@Override
	public void createNewLigthHouse() {
		world.add(new LigthHouse(randInt(900), randInt(600)));
	}

}
