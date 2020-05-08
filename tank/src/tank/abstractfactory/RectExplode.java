
    /**  
    * @Title: RectExplode.java
    * @Package tank.abstractfactory
    * @Description: TODO(用一句话描述该文件做什么)
    * @author YaHe
    * @date 2020年5月8日
    * @version V1.0  
    */
    
package tank.abstractfactory;

import java.awt.Color;
import java.awt.Graphics;

import tank.common.Audio;
import tank.common.ResourceLoding;
import tank.frame.TankFrame;

/**
    * @ClassName: RectExplode
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author YaHe
    * @date 2020年5月8日
    *
    */

public class RectExplode extends BaseExplode {
	public static int WIDTH = ResourceLoding.explods[0].getWidth();
	public static int HEIGHT = ResourceLoding.explods[0].getHeight();
	private int X, Y;
	private TankFrame tf = null;
	private int step = 0;

	public RectExplode(int x, int y, TankFrame tf) {
		X = x;
		Y = y;
		this.tf = tf;
		new Thread(()->new Audio("audio/explode.wav").play()).start();
	}

	

	@Override
	public void paint(Graphics g) {	
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillRect(X, Y, 10*step, 10*step);
		step++;
		if (step >= 5) {
			tf.explods.remove(this);
		}
		g.setColor(c);
	}

}
