
    /**  
    * @Title: GameFactory.java
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
    * @ClassName: GameFactory
    * @Description: 游戏的父类工厂
    * @author YaHe
    * @date 2020年5月8日
    *
    */

public abstract class GameFactory {
  public abstract BaseTank creatTank(int x, int y, Dir dir, TankFrame tf, Group group);
  public abstract BaseExplode creatExplode(int X,int Y,TankFrame tf);
  public abstract BaseBullet creatBullet(int x, int y, Dir dir, TankFrame tf, Group group);
  
}
