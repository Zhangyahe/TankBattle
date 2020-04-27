package tank.frame;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import tank.dto.BulletDto;
import tank.dto.TankDto;
import tank.util.Dir;

public class TankFrame extends Frame {

	public static final int GAME_WIDTH = 800;

	public static final int GAME_HEIGHT = 600;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	TankDto myTank = new TankDto(200, 400, Dir.DOWN, this);
//    public BulletDto bullet = new BulletDto(300, 300, Dir.DOWN);
	// 使用容器存储Bullet
	public List<BulletDto> bulletList = new ArrayList<BulletDto>(16);
	public List<TankDto> tanks = new ArrayList<TankDto>();
	public TankFrame() {
		setSize(GAME_WIDTH, GAME_HEIGHT);// 窗体的大小
		setResizable(false);// 是否可以修改大小
		setVisible(true);
		setTitle("HelloWorld");
		// 键盘监听处理
		this.addKeyListener(new MyKeyListener());
		// 窗口监听处理类
		addWindowListener(new WindowAdapter() {
			// 点击窗体关闭按钮，退出程序
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.white);
		g.drawString("子弹的数量" + bulletList.size(), 10, 60);
		g.setColor(c);
		myTank.paint(g);
		for (int i = 0; i < bulletList.size(); i++) {
           bulletList.get(i).paint(g);
		}
		//画敌人坦克
		for(int i = 0; i<tanks.size();i++) {
			tanks.get(i).paint(g);
		}
	}

	Image offScreenImage = null;

	/*
	 * (非 Javadoc)
	 * 
	 * 在系统paint执行之前，截获执行update; 双缓冲解决屏幕闪烁问题;将内存中图整个画到显存中显示到屏幕上
	 * 
	 * @param g
	 * 
	 * @see java.awt.Container#update(java.awt.Graphics)
	 */
	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	/**
	 * 
	 * @ClassName: MyKeyListener
	 * @Description: 按键实现子类
	 * @author YaHe
	 * @date 2020年4月25日
	 *
	 */
	class MyKeyListener extends KeyAdapter {
// 四个值表示按键的状态
		boolean bL = false;
		boolean bR = false;
		boolean bU = false;
		boolean bD = false;

		/**
		 * 按键按下的操作
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL = true;
				break;
			case KeyEvent.VK_RIGHT:
				bR = true;
				break;
			case KeyEvent.VK_UP:
				bU = true;
				break;
			case KeyEvent.VK_DOWN:
				bD = true;
				break;
			default:
				break;
			}
			setMainTankDir();
		}

		/**
		 * 坦克的方向赋值
		 */
		private void setMainTankDir() {
			if (!bL && !bU && !bR && !bD) {
				myTank.setMove(false);
			} else {
				myTank.setMove(true);
			}

			if (bL) {
				myTank.setDir(Dir.LEFT);
			}
			if (bU) {
				myTank.setDir(Dir.UP);
			}
			if (bR) {
				myTank.setDir(Dir.RIGHT);
			}
			if (bD) {
				myTank.setDir(Dir.DOWN);
			}

		}

		/**
		 * 按键抬起的操作
		 */
		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL = false;
				break;
			case KeyEvent.VK_RIGHT:
				bR = false;
				break;
			case KeyEvent.VK_UP:
				bU = false;
				break;
			case KeyEvent.VK_DOWN:
				bD = false;
				break;
			case KeyEvent.VK_CONTROL:
				myTank.fire();
				break;

			default:
				break;
			}
			setMainTankDir();
		}

	}
}
