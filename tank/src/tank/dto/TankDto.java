package tank.dto;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import tank.common.ResourceLoding;
import tank.design.strategy.DefaultFireStrategy;
import tank.frame.TankFrame;
import tank.util.Dir;
import tank.util.Group;

public class TankDto {
	private static final int SPEED = 6;
	private int X, Y;
	public static int WIDTH = ResourceLoding.goodTankD.getWidth();
	public static int HEIGHT = ResourceLoding.goodTankD.getHeight();
	private Dir dir = Dir.DOWN;
	private boolean move = true;
	private TankFrame tf = null;
	private boolean living = true;
	private Random random = new Random();
	private Group group = Group.GOOD;
	Rectangle rect = new Rectangle();

	public TankDto(int x, int y, Dir dir, TankFrame tf, Group group) {
		X = x;
		Y = y;
		this.dir = dir;
		this.tf = tf;
		this.group = group;
		rect.x = this.X;
		rect.y = this.Y;
		rect.width = WIDTH;
		rect.height = HEIGHT;
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

	public TankFrame getTf() {
		return tf;
	}

	public void setTf(TankFrame tf) {
		this.tf = tf;
	}

	/**
	 * 坦克构画出自己
	 * 
	 * @param g
	 */
	public void paint(Graphics g) {
		if (!living) {
			tf.tanks.remove(this);
		}

		switch (dir) {
		case LEFT:
			g.drawImage(this.group == Group.GOOD ? ResourceLoding.goodTankL : ResourceLoding.badTankL, X, Y, null);
			break;
		case UP:
			g.drawImage(this.group == Group.GOOD ? ResourceLoding.goodTankU : ResourceLoding.badTankU, X, Y, null);
			break;
		case RIGHT:
			g.drawImage(this.group == Group.GOOD ? ResourceLoding.goodTankR : ResourceLoding.badTankR, X, Y, null);
			break;
		case DOWN:
			g.drawImage(this.group == Group.GOOD ? ResourceLoding.goodTankD : ResourceLoding.badTankD, X, Y, null);
			break;
		default:
			break;
		}

		move();
	}

//判断坦克的移动
	private void move() {
		if (!move) {
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
		// update rect
		rect.x = this.X;
		rect.y = this.Y;
		// 敌人坦克打出子弹
		if (this.group == Group.BAD && random.nextInt(100) > 95) {
			this.fire();
		}
		if (this.group == Group.BAD && random.nextInt(100) > 95) {
			randomDir();
		}
		boundsCheck();
	}

	/**
	 * @Title: boundsCheck @Description: 坦克移动边界检测 @param 参数 @return void
	 *         返回类型 @throws
	 */

	private void boundsCheck() {
		if (this.X < 2) {
			X = 2;
		}
		if (this.Y < 28) {
			Y = 28;
		}
		if (this.X > TankFrame.GAME_WIDTH - TankDto.WIDTH - 2) {
			X = TankFrame.GAME_WIDTH - TankDto.WIDTH - 2;
		}
		if (this.Y > TankFrame.GAME_HEIGHT - TankDto.HEIGHT - 2) {
			Y = TankFrame.GAME_HEIGHT - TankDto.HEIGHT - 2;
		}
	}

	/**
	 * @Title: randomDir @Description: 敌方坦克随机转方向 @param 参数 @return void 返回类型 @throws
	 */

	private void randomDir() {
		this.dir = Dir.values()[random.nextInt(4)];
	}

	/**
	 * @Title: fire @Description: 坦克发射子弹 @param 参数 @return void 返回类型 @throws
	 */

	public void fire() {
		DefaultFireStrategy.getInstance().fire(this);;
	}

	/**
	 * @Title: die @Description: @param 参数 @return void 返回类型 @throws
	 */

	public void die() {
		this.living = false;
	}

}
