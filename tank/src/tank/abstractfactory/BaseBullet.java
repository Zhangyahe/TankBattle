
    /**  
    * @Title: BaseBullet.java
    * @Package tank.abstractfactory
    * @Description: TODO(用一句话描述该文件做什么)
    * @author YaHe
    * @date 2020年5月8日
    * @version V1.0  
    */
    
package tank.abstractfactory;

import java.awt.Graphics;

import tank.dto.TankDto;

/**
    * @ClassName: BaseBullet
    * @Description: 子弹的抽象类
    * @author YaHe
    * @date 2020年5月8日
    *
    */

public abstract class BaseBullet {
	public abstract void paint(Graphics g);
	    /**
	    * @Title: collideWith
	    * @Description: 子弹的碰撞方法
	    * @param @param tankDto    参数
	    * @return void    返回类型
	    * @throws
	    */
	    
	public abstract void collideWith(BaseTank tankDto);
}
