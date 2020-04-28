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
	public static BufferedImage tankL, tankU, tankR, tankD, bulletL, bulletU, bulletR, bulletD;
	public static BufferedImage[] explods = new BufferedImage[16];

	static {
		try {
			tankU = ImageIO.read(ResourceLoding.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
			tankL = ImageUtil.rotateImage(tankU,-90);
			tankR = ImageUtil.rotateImage(tankU,90);
			tankD = ImageUtil.rotateImage(tankU,180);

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
