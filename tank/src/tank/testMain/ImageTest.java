    /**  
    * @Title: ImageTest.java
    * @Package tank.testMain
    * @Description: 图片拿到内存测试类
    * @author YaHe
    * @date 2020年4月27日
    * @version V1.0  
    */
    
package tank.testMain;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Test;

/**
    * @ClassName: ImageTest
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author YaHe
    * @date 2020年4月27日
    *
    */

class ImageTest {

	@Test
	void test() {
		try {
			BufferedImage  image = ImageIO.read(new File("D:/LocalRepository/tank/src/tank/image/timg.jpg"));
		    assertNotNull(image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
