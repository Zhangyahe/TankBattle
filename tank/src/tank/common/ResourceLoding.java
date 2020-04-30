/**  
   * @Title: ResourceLoding.java
   * @Package tank.common
   * @Description: 资源包
   * @author YaHe
   * @date 2020年4月27日
   * @version V1.0  
   */

package tank.common;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @ClassName: ResourceLoding
 * @Description: 静态资源初始化
 * @author YaHe
 * @date 2020年4月27日
 *
 */

public class ResourceLoding {
	public  static BufferedImage goodTankL, goodTankU, goodTankR, goodTankD;
	public static BufferedImage badTankL, badTankU, badTankR, badTankD;
	public static BufferedImage bulletL, bulletU, bulletR, bulletD;
	public static BufferedImage[] explods = new BufferedImage[16];

	private ResourceLoding() {
	}
	
	static {
		try {
			goodTankU = ImageIO.read(ResourceLoding.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
			goodTankL = ImageUtil.rotateImage(goodTankU,-90);
			goodTankR = ImageUtil.rotateImage(goodTankU,90);
			goodTankD = ImageUtil.rotateImage(goodTankU,180);
			
			badTankU = ImageIO.read(ResourceLoding.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
			badTankL = ImageUtil.rotateImage(badTankU,-90);
			badTankR = ImageUtil.rotateImage(badTankU,90);
			badTankD = ImageUtil.rotateImage(badTankU,180);

			bulletU = ImageIO.read(ResourceLoding.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
			bulletL = ImageUtil.rotateImage(bulletU,-90);
			bulletR = ImageUtil.rotateImage(bulletU,90);
			bulletD = ImageUtil.rotateImage(bulletU,180);
			
			// 循环添加图片到Buffer数组
			for (int i = 0; i < 16; i++) {
				explods[i] = ImageIO
						.read(ResourceLoding.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
