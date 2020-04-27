package tank.dto;

import java.awt.Graphics;
import java.awt.Rectangle;

import tank.common.ResourceLoding;
import tank.frame.TankFrame;
import tank.util.Dir;

public class BulletDto {
	private static final int SPEED = 10;
	public static int WIDTH = ResourceLoding.bulletD.getWidth();
	public static int HEIGHT = ResourceLoding.bulletD.getHeight();
	private int X, Y;
	private Dir dir;
	private boolean living = true;
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
		if(!living) {
			tf.bulletList.remove(this);
		}
		switch (dir) {
		case LEFT:
			g.drawImage(ResourceLoding.bulletL, X,Y, null);
			break;
		case UP:
			g.drawImage(ResourceLoding.bulletU, X,Y, null);
			break;
		case RIGHT:
			g.drawImage(ResourceLoding.bulletR, X,Y, null);
			break;
		case DOWN:
			g.drawImage(ResourceLoding.bulletD, X,Y, null);
			break;
		default:
			break;
		}
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
			living = false;
		}
	}

	
	    /**
	    * @Title: collideWith
	    * @Description: 子弹是否碰撞上敌方坦克了
	    * @param @param tankDto    参数
	    * @return void    返回类型
	    * @throws
	    */
	    
	public void collideWith(TankDto tankDto) {
		//判断两个方块是否相交
		Rectangle rectBullet = new Rectangle(X, Y, WIDTH, HEIGHT);//子弹的矩形
		Rectangle rectTanks = new Rectangle(tankDto.getX(), tankDto.getY(), TankDto.Width, TankDto.Height);//tanks的矩形
		if(rectBullet.intersects(rectTanks)) {
			tankDto.die();
			this.die();
		}
	}

		
		    /**
		    * @Title: die
		    * @Description: 子弹消失
		    * @param     参数
		    * @return void    返回类型
		    * @throws
		    */
		    
		private void die() {
			this.living = false;
			
		}
}
