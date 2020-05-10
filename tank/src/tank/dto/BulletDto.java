package tank.dto;

import java.awt.Graphics;
import java.awt.Rectangle;

import tank.common.PropertiesMgr;
import tank.common.ResourceLoding;
import tank.design.GameModel;
import tank.frame.TankFrame;
import tank.util.Dir;
import tank.util.Group;

public class BulletDto {
	private static final int SPEED = PropertiesMgr.getInitTankCount("bulletSpeed");
	public static int WIDTH = ResourceLoding.bulletD.getWidth();
	public static int HEIGHT = ResourceLoding.bulletD.getHeight();
	private int X, Y;
	private Dir dir;
	private boolean living = true;
	private GameModel gm = null;
	private Group group = Group.BAD;
	Rectangle rect = new Rectangle();
	
	public BulletDto(int x, int y, Dir dir,GameModel gm, Group group) {
		X = x;
		Y = y;
		this.dir = dir;
		this.gm = gm;
		this.group = group;
		rect.x = this.X;
		rect.y = this.Y;
		rect.width = WIDTH;
		rect.height = HEIGHT;
		gm.bulletList.add(this);
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	/**
	 * 子弹构画出自己
	 * 
	 * @param g
	 */
	public void paint(Graphics g) {
		if (!living) {
			gm.bulletList.remove(this);
		}
		switch (dir) {
		case LEFT:
			g.drawImage(ResourceLoding.bulletL, X, Y, null);
			break;
		case UP:
			g.drawImage(ResourceLoding.bulletU, X, Y, null);
			break;
		case RIGHT:
			g.drawImage(ResourceLoding.bulletR, X, Y, null);
			break;
		case DOWN:
			g.drawImage(ResourceLoding.bulletD, X, Y, null);
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
		//update rect
		rect.x = this.X;
		rect.y = this.Y;
		
		if (X < 0 || Y < 0 || X > TankFrame.GAME_WIDTH || Y > TankFrame.GAME_HEIGHT) {
			living = false;
		}
	}

	/**
	 * @Title: collideWith @Description: 子弹是否碰撞上敌方坦克了 @param @param tankDto
	 * 参数 @return void 返回类型 @throws
	 */

	public void collideWith(TankDto tankDto) {
		if (this.group == tankDto.getGroup()) {
			return;
		}
		// 判断两个方块是否相交
//		Rectangle rectBullet = new Rectangle(X, Y, WIDTH, HEIGHT);// 子弹的矩形
//		Rectangle rectTanks = new Rectangle(tankDto.getX(), tankDto.getY(), TankDto.WIDTH, TankDto.HEIGHT);// tanks的矩形
		if (rect.intersects(tankDto.rect)) {
			tankDto.die();
			this.die();
			int eX = tankDto.getX() + TankDto.WIDTH / 2 - Explods.WIDTH / 2;
			int eY = tankDto.getY() + TankDto.HEIGHT / 2 - Explods.HEIGHT / 2;
			gm.explods.add(new Explods(eX, eY, gm));
		}
	}

	/**
	 * @Title: die @Description: 子弹消失 @param 参数 @return void 返回类型 @throws
	 */

	private void die() {
		this.living = false;

	}
}
