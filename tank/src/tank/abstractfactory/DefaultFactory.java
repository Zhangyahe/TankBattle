
    /**  
    * @Title: DefaultFactory.java
    * @Package tank.abstractfactory
    * @Description: TODO(用一句话描述该文件做什么)
    * @author YaHe
    * @date 2020年5月8日
    * @version V1.0  
    */
    
package tank.abstractfactory;

import tank.dto.BulletDto;
import tank.dto.Explods;
import tank.dto.TankDto;
import tank.frame.TankFrame;
import tank.util.Dir;
import tank.util.Group;

/**
    * @ClassName: DefaultFactory
    * @Description: 产生默认形式产品的工厂
    * @author YaHe
    * @date 2020年5月8日
    *
    */

public class DefaultFactory extends GameFactory {

	@Override
	public BaseTank creatTank(int x, int y, Dir dir, TankFrame tf, Group group) {
		return new TankDto(x, y, dir, tf, group);
	}
	    
	@Override
	public BaseExplode creatExplode(int X, int Y, TankFrame tf) {
		return new Explods(X, Y, tf);
	}

	@Override
	public BaseBullet creatBullet(int x, int y, Dir dir, TankFrame tf, Group group) {
		return new BulletDto(x, y, dir, tf, group);
	}
}
