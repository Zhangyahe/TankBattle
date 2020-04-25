package tank.dto;

import java.awt.Graphics;

import tank.util.Dir;

public class TankDto {
	private static final int SPEED = 5;
	private int X, Y;
	private Dir dir = Dir.DOWN;
	private boolean move = false;

	public TankDto(int x, int y, Dir dir) {
		super();
		X = x;
		Y = y;
		this.dir = dir;
	}

	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public boolean isMove() {
		return move;
	}

	public void setMove(boolean move) {
		this.move = move;
	}

	/**
	 * 坦克构画出自己
	 * 
	 * @param g
	 */
	public void paint(Graphics g) {
		g.fillRect(X, Y, 50, 50);
		move();
	}

//判断坦克的移动
	private void move() {
		if(!move) {
			return;
		}
		switch (dir) {
		case LEFT:
			X -= SPEED;
			break;
		case UP:
			Y -= SPEED;
			break;
		case RIGHT:
			X += SPEED;
			break;
		case DOWN:
			Y += SPEED;
			break;
		default:
			break;
		}
	}

}
