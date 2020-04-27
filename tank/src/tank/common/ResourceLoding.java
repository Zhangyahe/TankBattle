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
   public static BufferedImage tankL,tankU,tankR,tankD;
   
   static {
	   try {
		tankL  = ImageIO.read(ResourceLoding.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
		tankU  = ImageIO.read(ResourceLoding.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
		tankR  = ImageIO.read(ResourceLoding.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
		tankD  = ImageIO.read(ResourceLoding.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
	} catch (IOException e) {
		e.printStackTrace();
	}

   }
}
