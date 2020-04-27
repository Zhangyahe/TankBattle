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
   public static BufferedImage tankL,tankU,tankR,tankD,bulletL,bulletU,bulletR,bulletD;
   
   static {
	   try {
		tankL  = ImageIO.read(ResourceLoding.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
		tankU  = ImageIO.read(ResourceLoding.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
		tankR  = ImageIO.read(ResourceLoding.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
		tankD  = ImageIO.read(ResourceLoding.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
		
		bulletL  = ImageIO.read(ResourceLoding.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
		bulletU  = ImageIO.read(ResourceLoding.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
		bulletR  = ImageIO.read(ResourceLoding.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
		bulletD  = ImageIO.read(ResourceLoding.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
		
	} catch (IOException e) {
		e.printStackTrace();
	}

   }
}
