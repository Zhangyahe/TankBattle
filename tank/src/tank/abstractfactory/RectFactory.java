
    /**  
    * @Title: RectFactory.java
    * @Package tank.abstractfactory
    * @Description: TODO(用一句话描述该文件做什么)
    * @author YaHe
    * @date 2020年5月8日
    * @version V1.0  
    */
    
package tank.abstractfactory;

import tank.frame.TankFrame;
import tank.util.Dir;
import tank.util.Group;

/**
    * @ClassName: RectFactory
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author YaHe
    * @date 2020年5月8日
    *
    */

public class RectFactory extends GameFactory {

	@Override
	public BaseTank creatTank(int x, int y, Dir dir, TankFrame tf, Group group) {
		return new RectTank(x,  y, dir, tf, group);
	}

	@Override
	public BaseExplode creatExplode(int X, int Y, TankFrame tf) {
		return new RectExplode(X, Y, tf);
	}

	@Override
	public BaseBullet creatBullet(int x, int y, Dir dir, TankFrame tf, Group group) {
		return new RectBullet(x, y, dir, tf, group);
	}

}
