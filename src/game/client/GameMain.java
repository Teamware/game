package game.client;

import game.client.domain.World;
import game.client.views.WorldViewImpl;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dev.GWTMain;
import com.google.gwt.thirdparty.guava.common.annotations.GwtCompatible;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GameMain implements EntryPoint {

	private Timer timer;
	private World world;
	private WorldViewImpl worldView;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		world = new World();
		worldView = new WorldViewImpl(world, Window.getClientHeight(), Window.getClientWidth());
		RootPanel.get().add(worldView);
		
		

		timer = new Timer() { @Override public void run() {
			world.tick();
		}};

		timer.scheduleRepeating(33); // Para 30 FPS 1000/30 = 33
	}

}
