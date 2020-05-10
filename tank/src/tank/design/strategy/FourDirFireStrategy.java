
/**  
* @Title: FourDirFireStrategy.java
* @Package tank.design.strategy
* @Description: TODO(用一句话描述该文件做什么)
* @author YaHe
* @date 2020年5月4日
* @version V1.0  
*/

package tank.design.strategy;

import tank.common.Audio;
import tank.dto.BulletDto;
import tank.dto.TankDto;
import tank.util.Dir;
import tank.util.Group;

/**
 * @ClassName: FourDirFireStrategy
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author YaHe
 * @date 2020年5月4日
 *
 */

public class FourDirFireStrategy implements FireStrategy {

//	/**
//	 * 创建一个新的实例 FourDirFireStrategy.
//	 *
//	 */
//	private FourDirFireStrategy() {
//	}
//
//	private static class FourDirFireStrategyHanlder {
//		private static final FourDirFireStrategy INSTANCE = new FourDirFireStrategy();
//	}
//
//	public static FourDirFireStrategy getInstance() {
//		return FourDirFireStrategyHanlder.INSTANCE;
//	}
	/*
	 * (非 Javadoc)
	 * 
	 * 
	 * @param t
	 * 
	 * @see tank.design.strategy.FireStrategy#fire(tank.dto.TankDto)
	 */

	@Override
	public void fire(TankDto t) {
		int bx = t.getX() + TankDto.WIDTH / 2 - BulletDto.WIDTH / 2;
		int by = t.getY() + TankDto.HEIGHT / 2 - BulletDto.HEIGHT / 2;

		Dir[] dirs = Dir.values();

		for (Dir dir : dirs) {
			new BulletDto(bx, by, dir, t.getGm(), t.getGroup());
		}

		if (t.getGroup() == Group.GOOD) {
			new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
		}

	}

}
