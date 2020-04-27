package tank;

import tank.dto.TankDto;
import tank.frame.TankFrame;
import tank.util.Dir;

public class T {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		TankFrame frame = new TankFrame();
//		初始化敌方tanks
		for(int i = 0 ;i <5 ; i++){
			frame.tanks.add(new TankDto(50 +i*80, 200, Dir.DOWN, frame));
		}
		while(true) {
			Thread.sleep(100);
			frame.repaint();
		}
	}
}
