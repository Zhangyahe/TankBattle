package tank.dto;

import java.awt.Graphics;
import java.util.Random;

import tank.common.ResourceLoding;
import tank.frame.TankFrame;
import tank.util.Dir;
import tank.util.Group;

public class TankDto {
	private static final int SPEED = 1;
	private int X,Y;
	public static int Width = ResourceLoding.tankD.getWidth();
	public static int Height = ResourceLoding.tankD.getHeight();
	private Dir dir = Dir.DOWN;
	private boolean move = true;
	private TankFrame tf = null;
	private boolean living = true;
	private Random random = new Random();
	private Group group = Group.GOOD;

	public TankDto(int x, int y, Dir dir,TankFrame tf,Group group) {
		X = x;
		Y = y;
		this.dir = dir;
		this.tf = tf;
		this.group = group;
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

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	/**
	 * 坦克构画出自己
	 * 
	 * @param g
	 */
	public void paint(Graphics g) {
		if(!living) {
			tf.tanks.remove(this);
		}
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
		//敌人坦克打出子弹
		if(random.nextInt(10) > 8) {
			this.fire();
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
		int bx = this.X + TankDto.Width/2 - BulletDto.WIDTH/2;
		int by = this.Y + TankDto.Height/2 - BulletDto.HEIGHT/2;
		tf.bulletList.add((new BulletDto(bx, by, this.dir,this.tf,this.group)));
	}

		
		    /**
		    * @Title: die
		    * @Description: 
		    * @param     参数
		    * @return void    返回类型
		    * @throws
		    */
		    
		public void die() {
			this.living = false;
		}

}
