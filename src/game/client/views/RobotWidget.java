package game.client.views;

import game.client.domain.Robot;
import game.client.domain.listeners.ChangeListener;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;

public class RobotWidget implements ChangeListener {
	
	private static final String IMAGE = "images/robot1/Robot1.png";
	public int imageIndex;
	public Image image;
	public AbsolutePanel panel;
	private final Robot robot;

	public RobotWidget(AbsolutePanel panel, Robot robot) {
		this.robot = robot;
		this.imageIndex = 0;
		this.panel = panel;
		image = new Image(IMAGE, 0, 0, 86, 126);
		this.panel.add(image);
		robot.addListener(this);
		onChange();
	}

	/* (non-Javadoc)
	 * @see jogo.client.RobotListener#update()
	 */
	@Override
	public void onChange() {
		panel.setWidgetPosition(image, robot.getLeft(), robot.getTop());
		
		if(++imageIndex>13)
			imageIndex = 0;
		
		int spriteLeft;
		int spriteTop;
		int spriteWidth;
		int spriteHeight;
		if(robot.isHeadingDown()) {
			spriteHeight = 126;
			spriteWidth = 86;
			spriteTop = 0;
			spriteLeft = imageIndex * 100;
		} else if(robot.isHeadingUp()) {
			spriteHeight = 132;
			spriteWidth = 88;
			spriteTop = 150;
			spriteLeft = imageIndex * 100;			
		} else if(robot.isHeadingLeft()) {
			if(imageIndex==13)
				imageIndex = 0;
			spriteHeight = 129;
			spriteWidth = 103;
			spriteTop = 300;
			spriteLeft = imageIndex * 150;			
		} else if(robot.isHeadingRight()) {
			spriteHeight = 127;
			spriteWidth = 110;
			spriteTop = 450;
			spriteLeft = imageIndex * 150;			
		} else {
			throw new IllegalStateException("Heading invalido " + robot.heading);
		}
		
		image.setVisibleRect(spriteLeft, spriteTop, spriteWidth, spriteHeight);
	}
}