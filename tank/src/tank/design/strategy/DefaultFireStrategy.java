
/**  
* @Title: DefaultFireStrategy.java
* @Package tank.design.strategy
* @Description: TODO(用一句话描述该文件做什么)
* @author YaHe
* @date 2020年5月3日
* @version V1.0  
*/

package tank.design.strategy;

import tank.common.Audio;
import tank.dto.BulletDto;
import tank.dto.TankDto;
import tank.util.Group;

/**
 * @ClassName: DefaultFireStrategy
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author YaHe
 * @date 2020年5月3日
 *
 */

public class DefaultFireStrategy implements FireStrategy {
	private static final DefaultFireStrategy INSTANCE = new DefaultFireStrategy();

	private DefaultFireStrategy() {
	}

	public static DefaultFireStrategy getInstance() {
		return DefaultFireStrategy.INSTANCE;
	}

	@Override
	public void fire(TankDto t) {
		int bx = t.getX() + TankDto.WIDTH / 2 - BulletDto.WIDTH / 2;
		int by = t.getY() + TankDto.HEIGHT / 2 - BulletDto.HEIGHT / 2;
		new BulletDto(bx, by, t.getDir(), t.getTf(), t.getGroup());
//		if (t.getGroup() == Group.GOOD) {
//			
//		}
	}

}
