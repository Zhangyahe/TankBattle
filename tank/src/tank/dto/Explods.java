package tank.dto;

import java.awt.Graphics;

import tank.abstractfactory.BaseExplode;
import tank.common.Audio;
import tank.common.ResourceLoding;
import tank.frame.TankFrame;

public class Explods extends BaseExplode{
	public static int WIDTH = ResourceLoding.explods[0].getWidth();
	public static int HEIGHT = ResourceLoding.explods[0].getHeight();
	private int X, Y;
	private TankFrame tf = null;
	private int step = 0;

	public Explods(int x, int y, TankFrame tf) {
		X = x;
		Y = y;
		this.tf = tf;
		new Thread(()->new Audio("audio/explode.wav").play()).start();
	}

	/**
	 * 构画出自己
	 * 
	 * @param g
	 */
	@Override
	public void paint(Graphics g) {
		g.drawImage(ResourceLoding.explods[step++], X, Y, null);
		if (step >= ResourceLoding.explods.length) {
			tf.explods.remove(this);
		}
	}

}
