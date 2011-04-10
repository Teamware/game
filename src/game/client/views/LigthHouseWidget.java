package game.client.views;

import game.client.domain.LigthHouse;
import game.client.domain.listeners.ChangeListener;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;

public class LigthHouseWidget implements ChangeListener {
	public AbsolutePanel gamePanel;
	public Image base;
	public int idx;
	public Image light;

	public LigthHouseWidget(AbsolutePanel gamePanel, LigthHouse ligthhouse) {
		this.gamePanel = gamePanel;
		this.idx = 0;
		this.base = new Image(
				"images/T_lighthouse/lighthouse%20AA%20tileset.png", 0, 0, 160,
				288);
		this.light = new Image(
				"images/T_lighthouse/ani%20lighthouse%20light%20bitmaps/ani%20lighthouse%20light.png",
				0, 0, 96, 96);
		this.gamePanel.add(base);
		this.gamePanel.setWidgetPosition(base, ligthhouse.getX(), ligthhouse.getY());
		this.gamePanel.add(light);
		this.gamePanel.setWidgetPosition(light, ligthhouse.getX() + 16,
				ligthhouse.getY() + 65);
		ligthhouse.add(this);
	}

	@Override
	public void onChange() {
		if (++idx > 15)
			idx = 0;
		int left = (idx % 4) * 96;
		int top = (idx / 4) * 96;
		light.setVisibleRect(left, top, 96, 96);
	}
}