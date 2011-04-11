package game.client.domain;

import game.client.domain.listeners.ChangeListener;
import game.client.domain.listeners.ChangeNotifier;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.GwtTransient;



public class Robot implements WorldObject, Serializable {

	private static final long serialVersionUID = 1L;
	static final String LEFT_UP = "LU";
	static final String RIGHT_UP = "RU";
	static final String LEFT_DOWN = "LD";
	static final String RIGHT_DOWN = "RD";
	private static final int STEP = 5;	
	private int left=0;
	private int top=0;
	public String heading = LEFT_DOWN;
	
	@GwtTransient
	private ChangeNotifier notifier = new ChangeNotifier();
	
	public Robot() {
	}
	
	public Robot(int left, int top) {
		this.left = left;
		this.top = top;
	}
	
	public void addListener(ChangeListener listener) {
		notifier.add(listener);
	}

	public void rigth() {
		heading = RIGHT_DOWN;
		top += STEP;
		left += STEP;
		notifyRobotMove();
	}

	private void notifyRobotMove() {
		notifier.notifyChange();
	}
	
	public void left() {
		heading = LEFT_UP;
		top -= STEP;
		left -= STEP;
		notifyRobotMove();
	}

	public void down() {
		heading = LEFT_DOWN;
		top += STEP;
		left -= STEP;
		notifyRobotMove();
	}

	public void up() {
		heading = RIGHT_UP;
		top -= STEP;
		left += STEP;
		notifyRobotMove();
	}

	public int getLeft() {
		return left;
	}

	public int getTop() {
		return top;
	}

	public boolean isHeadingDown() {
		return Robot.LEFT_DOWN.equals(heading);
	}

	public boolean isHeadingUp() {
		return Robot.RIGHT_UP.equals(heading);
	}

	public boolean isHeadingLeft() {
		return Robot.LEFT_UP.equals(heading);
	}

	public boolean isHeadingRight() {
		return Robot.RIGHT_DOWN.equals(heading);
	}
	
}