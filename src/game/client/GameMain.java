package game.client;

import game.client.domain.World;
import game.client.domain.WorldObject;
import game.client.domain.listeners.WorldListener;
import game.client.views.WorldViewImpl;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GameMain implements EntryPoint {

	private Timer timer;
	private World world;
	private WorldViewImpl worldView;
	protected int left=100;
	protected int top=100;
	private GameServiceAsync rpc;

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
		
		
		rpc = GWT.create(GameService.class);
		
		rpc.hello(new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		rpc.listenNewObjects("Teste", new AsyncCallback<WorldObject>() {
			
			@Override
			public void onSuccess(WorldObject object) {
				world.add(object);
				GWT.log(object.toString());
			}
			
			@Override
			public void onFailure(Throwable caught) {
				
			}
		});
		/**/
		
		world.add(new WorldListener() {
			
			@Override
			public void onNewObject(World world, WorldObject object) {
				rpc.add(object, new AsyncCallback<Void>() {
					
					@Override
					public void onSuccess(Void result) {
					}
					
					@Override
					public void onFailure(Throwable caught) {
					}
				});
			}
		});
		
	}

}
