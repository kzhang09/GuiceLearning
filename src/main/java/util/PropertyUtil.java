package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil
{

	/**
	 * 读取配置文件属性
	 *
	 * @param prefix
	 * @param cla
	 * @return
	 */
	public static Properties loadFile(String prefix, Class<?> cla) {
		String fileName = prefix;
		Properties prop = new Properties();
		InputStream in = null;
		try {
			in = cla.getResource("/" + fileName).openStream();
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
