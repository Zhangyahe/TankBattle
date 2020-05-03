/**  
* @Title: Properties.java
* @Package tank.common
* @Description: TODO(用一句话描述该文件做什么)
* @author YaHe
* @date 2020年4月29日
* @version V1.0  
*/

package tank.common;

import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName: Properties
 * @Description: 配置文件管理类
 * @author YaHe
 * @date 2020年4月29日
 *
 */

public class PropertiesMgr {
	private static final Properties props = new Properties();

	private PropertiesMgr() {
	}	
	
	static {
		try {
			props.load(PropertiesMgr.class.getClassLoader().getResourceAsStream("config"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static  Object get(String key) {
		if (props == null) {
			return null;
		}
		return props.get(key);
	}
	
	public static  Integer getInitTankCount(String key) {
		if (props == null) {
			return 0;
		}
		return Integer.parseInt((String) props.get(key));
	}

}
