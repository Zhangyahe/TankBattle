package tank;

import tank.common.PropertiesMgr;
import tank.dto.TankDto;
import tank.frame.TankFrame;
import tank.util.Dir;
import tank.util.Group;

public class T {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		TankFrame frame = new TankFrame();
		int initTankCount =  PropertiesMgr.getInitTankCount("initTankCount");
//		初始化敌方tanks
		for (int i = 0; i < initTankCount; i++) {
			frame.tanks.add(new TankDto(50 + i * 80, 200, Dir.DOWN, frame, Group.BAD));
		}
		while (true) {
			Thread.sleep(100);
			frame.repaint();
		}
	}
}
