package tank.dto;

import java.awt.Graphics;

import tank.common.ResourceLoding;
import tank.frame.TankFrame;

public class Explods {
	public static int WIDTH = ResourceLoding.explods[0].getWidth();
	public static int HEIGHT = ResourceLoding.explods[0].getHeight();
	private int X, Y;
	private boolean living = true;
	private TankFrame tf = null;
	private int step = 0;

	public Explods(int x, int y, TankFrame tf) {
		X = x;
		Y = y;
		this.tf = tf;

	}

	/**
	 * 构画出自己
	 * 
	 * @param g
	 */
	public void paint(Graphics g) {
		g.drawImage(ResourceLoding.explods[step++], X, Y, null);
		if (step >= ResourceLoding.explods.length) {
			step = 0;
		}
	}

}
