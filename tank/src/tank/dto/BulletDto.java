package tank.dto;

import java.awt.Color;
import java.awt.Graphics;

import tank.frame.TankFrame;
import tank.util.Dir;

public class BulletDto {
	private static final int SPEED = 6;
	private static int WIDTH = 10, HEIGHT = 10;
	private int X, Y;
	private Dir dir;
	private boolean live = true;
	private TankFrame tf = null;
	
	public BulletDto(int x, int y, Dir dir,TankFrame tf) {
		X = x;
		Y = y;
		this.dir = dir;
		this.tf = tf;
	}

	/**
	 * 子弹构画出自己
	 * 
	 * @param g
	 */
	public void paint(Graphics g) {
		if(!live) {
			tf.bulletList.remove(this);
		}
		Color c = g.getColor();
		g.setColor(Color.RED);
		
		g.fillOval(X, Y, WIDTH, HEIGHT); // 正方形的内切圆
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
		}
		if (X < 0 || Y < 0 || X > TankFrame.GAME_WIDTH  || Y > TankFrame.GAME_HEIGHT) {
			live = false;
		}
	}
}
