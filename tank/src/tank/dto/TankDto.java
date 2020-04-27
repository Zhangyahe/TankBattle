package tank.dto;

import java.awt.Color;
import java.awt.Graphics;

import tank.common.ResourceLoding;
import tank.frame.TankFrame;
import tank.util.Dir;

public class TankDto {
	private static final int SPEED = 5;
	private int X, Y;
	private Dir dir = Dir.DOWN;
	private boolean move = false;
	private TankFrame tf = null;

	public TankDto(int x, int y, Dir dir,TankFrame tf) {
		X = x;
		Y = y;
		this.dir = dir;
		this.tf = tf;
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
		switch (dir) {
		case LEFT:
			g.drawImage(ResourceLoding.tankL, X,Y, null);
			break;
		case UP:
			g.drawImage(ResourceLoding.tankU, X,Y, null);
			break;
		case RIGHT:
			g.drawImage(ResourceLoding.tankR, X,Y, null);
			break;
		case DOWN:
			g.drawImage(ResourceLoding.tankD, X,Y, null);
			break;
		default:
			break;
		}
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

	
	    /**
	    * @Title: fire
	    * @Description: 坦克发射子弹
	    * @param     参数
	    * @return void    返回类型
	    * @throws
	    */
	    
	public void fire() {
		tf.bulletList.add((new BulletDto(this.X, this.Y, this.dir,this.tf)));
	}

}
