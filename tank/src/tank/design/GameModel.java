
    /**  
    * @Title: GameModel.java
    * @Package tank.design
    * @Description: TODO(用一句话描述该文件做什么)
    * @author YaHe
    * @date 2020年5月10日
    * @version V1.0  
    */
    
package tank.design;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import tank.common.PropertiesMgr;
import tank.dto.BulletDto;
import tank.dto.Explods;
import tank.dto.TankDto;
import tank.util.Dir;
import tank.util.Group;

/**
    * @ClassName: GameModel
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author YaHe
    * @date 2020年5月10日
    *
    */

public class GameModel {
	TankDto myTank = new TankDto(200, 400, Dir.DOWN, this, Group.GOOD);
  // 使用容器存储Bullet
	public List<BulletDto> bulletList = new ArrayList<BulletDto>(16);
	public List<TankDto> tanks = new ArrayList<TankDto>();
  public List<Explods> explods = new ArrayList<Explods>();

	
		public GameModel() {
			int initTankCount =  PropertiesMgr.getInitTankCount("initTankCount");
//			初始化敌方tanks
			for (int i = 0; i < initTankCount; i++) {
				tanks.add(new TankDto(50 + i * 80, 200, Dir.DOWN, this, Group.BAD));
			}
		}
		    /**
		    * @Title: paint
		    * @Description: TODO(这里用一句话描述这个方法的作用)
		    * @param @param g    参数
		    * @return void    返回类型
		    * @throws
		    */
		    
		public void paint(Graphics g) {
			Color c = g.getColor();
			g.setColor(Color.white);
			g.drawString("子弹的数量" + bulletList.size(), 10, 60);
			g.drawString("敌人的数量" + tanks.size(), 10, 80);
			g.drawString("爆炸的数量" + explods.size(), 10, 100);
			g.setColor(c);
			myTank.paint(g);
			for (int i = 0; i < bulletList.size(); i++) {
				bulletList.get(i).paint(g);
			}
			for (int i = 0; i < explods.size(); i++) {
				explods.get(i).paint(g);
			}
			// 画敌人坦克
			for (int i = 0; i < tanks.size(); i++) {
				tanks.get(i).paint(g);
			}
			// 做碰撞检测--子弹是否和坦克碰上了
			for (int i = 0; i < bulletList.size(); i++) {
				for (int j = 0; j < tanks.size(); j++) {
					bulletList.get(i).collideWith(tanks.get(j));
				}
			}
		}
			
			    /**
			    * @Title: getMainTank
			    * @Description: TODO(这里用一句话描述这个方法的作用)
			    * @param @return    参数
			    * @return TankDto    返回类型
			    * @throws
			    */
			    
			public TankDto getMainTank() {
				return myTank;
			}

}
