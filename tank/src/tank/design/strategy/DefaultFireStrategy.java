
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
	/**
	 * 禁止外部创建一个新的实例 FireStrategyImp.
	 *
	 */

//	private DefaultFireStrategy() {
//	}
//
//	private static class FireStrategyImpHanlder {
//		private static final DefaultFireStrategy INSTANCE = new DefaultFireStrategy();
//	}
//
//	public static DefaultFireStrategy getInstance() {
//		return FireStrategyImpHanlder.INSTANCE;
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
		new BulletDto(bx, by, t.getDir(), t.getTf(), t.getGroup());
		if (t.getGroup() == Group.GOOD) {
			new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
		}
	}
}
