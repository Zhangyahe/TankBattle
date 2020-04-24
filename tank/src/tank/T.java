package tank;

public class T {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TankFrame frame = new TankFrame();
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			frame.repaint();
		}
	}
}
