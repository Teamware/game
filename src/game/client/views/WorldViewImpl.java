package game.client.views;

import game.client.domain.LigthHouse;
import game.client.domain.Robot;
import game.client.domain.World;
import game.client.domain.WorldObject;
import game.client.presenter.WorldPresenter;
import game.client.presenter.WorldPresenterImpl;
import game.client.presenter.WorldView;

import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.SplitLayoutPanel;

public class WorldViewImpl extends Composite implements WorldView {

	private AbsolutePanel gamePanel;
	private FocusPanel focus;
	private WorldPresenter presenter;
	private MenuBar menu;
	private SplitLayoutPanel dock;
	
	public WorldViewImpl(World world, int heigth, int width) {		
		presenter = new WorldPresenterImpl(this, world);

		gamePanel = new AbsolutePanel();		
		gamePanel.getElement().getStyle().setPosition(Position.RELATIVE);
		
		menu = new MenuBar(true);
		menu.addItem("New robot", new Command() { @Override public void execute() {
			presenter.createNewRobot();
		}});
		menu.addItem("New ligthHouse", new Command() { @Override public void execute() {
			presenter.createNewLigthHouse();
		}});

		dock = new SplitLayoutPanel();
		dock.addNorth(new HTML("header"), 60);
		dock.addSouth(new HTML("footer"), 60);
		dock.addWest(menu, 200);
		dock.add(gamePanel);
		dock.setHeight( heigth + "px");
		dock.setWidth( width + "px");

			
		focus = new FocusPanel();
		focus.add(dock);		
		focus.setFocus(true);
		
		focus.addKeyDownHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				switch (event.getNativeKeyCode()) {
				case KeyCodes.KEY_UP:
					presenter.up();
					break;
				case KeyCodes.KEY_DOWN:
					presenter.down();
					break;
				case KeyCodes.KEY_LEFT:
					presenter.left();
					break;
				case KeyCodes.KEY_RIGHT:
					presenter.rigth();
					break;
				}

			}
		});
				/**/

		initWidget(focus);
	}
	
	@Override
	public void add(WorldObject object) {
		if (object instanceof Robot) {
			new RobotWidget(gamePanel, (Robot) object);
		} else if (object instanceof LigthHouse) {
			new LigthHouseWidget(gamePanel, (LigthHouse) object);
		}

	}

}
