package tank.dto;

import java.awt.Graphics;

import tank.common.Audio;
import tank.common.ResourceLoding;
import tank.design.GameModel;

public class Explods {
	public static int WIDTH = ResourceLoding.explods[0].getWidth();
	public static int HEIGHT = ResourceLoding.explods[0].getHeight();
	private int X, Y;
	private int step = 0;
	private GameModel gm = null;

	public Explods(int x, int y, GameModel gm) {
		X = x;
		Y = y;
		this.gm = gm;
		new Thread(()->new Audio("audio/explode.wav").play()).start();
	}

	/**
	 * 构画出自己
	 * 
	 * @param g
	 */
	public void paint(Graphics g) {
		g.drawImage(ResourceLoding.explods[step++], X, Y, null);
		if (step >= ResourceLoding.explods.length) {
			gm.explods.remove(this);
		}
	}

}
