package tank.testMain;

import tank.frame.TankFrame;

public class T {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		TankFrame frame = new TankFrame();
		while(true) {
			Thread.sleep(100);
			frame.repaint();
		}
	}
}
