package game.client.domain.listeners;

public class ChangeNotifier extends AbstractNotifier<ChangeListener> {

	public void notifyChange() {
		notify(new NotifyClosure<ChangeListener>() {
			@Override
			public void notify(ChangeListener listener) {
				listener.onChange();
			}
		});
	}

}
