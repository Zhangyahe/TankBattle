
/**  
* @Title: BaseTank.java
* @Package tank.abstractfactory
* @Description: TODO(用一句话描述该文件做什么)
* @author YaHe
* @date 2020年5月8日
* @version V1.0  
*/

package tank.abstractfactory;

import java.awt.Graphics;
import java.awt.Rectangle;

import tank.util.Group;

/**
 * @ClassName: BaseTank
 * @Description: 抽象类Tank
 * @author YaHe
 * @date 2020年5月8日
 *
 */

public abstract class BaseTank {
	public Group group = Group.BAD;
	public Rectangle rect = new Rectangle();
	public abstract void paint(Graphics g);

	public abstract int getX();

	public abstract int getY();
 
	public abstract void die();
	    
	public Group getGroup() {
    return this.group;
    }
}
