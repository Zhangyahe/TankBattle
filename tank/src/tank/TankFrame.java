package tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import tank.dto.TankDto;
import tank.util.Dir;

public class TankFrame extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	TankDto myTank = new TankDto(200, 200, Dir.DOWN);

	public TankFrame() {
		setSize(800, 600);// 窗体的大小
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
		myTank.paint(g);
	}

	class MyKeyListener extends KeyAdapter {
// 四个值表示按键的状态
		boolean bL = false;
		boolean bR = false;
		boolean bU = false;
		boolean bD = false;

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
			default:
				break;
			}
			setMainTankDir();
		}

	}
}
