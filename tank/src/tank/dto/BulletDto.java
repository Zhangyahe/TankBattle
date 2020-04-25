package tank.dto;

import java.awt.Color;
import java.awt.Graphics;

import tank.util.Dir;

public class BulletDto {
	private static final int SPEED = 6;
	private static int WIDTH = 10,HEIGHT = 10;
	private int X,Y;
	private Dir dir;
	
	public BulletDto(int x, int y, Dir dir) {
		X = x;
		Y = y;
		this.dir = dir;
	}
	
	/**
	 * 子弹构画出自己
	 * 
	 * @param g
	 */
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(X, Y, WIDTH, HEIGHT); //正方形的内切圆
		g.setColor(c);
		move();
	}

	private void move() {
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
