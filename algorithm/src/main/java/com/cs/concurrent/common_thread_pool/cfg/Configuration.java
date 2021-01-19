package com.cs.concurrent.common_thread_pool.cfg;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * 读取配置文件
 * @author jxw
 */
public class Configuration {
	
	private static Properties props = new Properties();

	static {
		InputStream inputStream = Configuration.class.getResourceAsStream("/config.properties");
		InputStreamReader inputStreamReader = null;
		try {
			inputStreamReader = new InputStreamReader(inputStream,Charset.forName("UTF-8"));
			props.load(inputStreamReader);
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	
	public static String getConfiguration(String key) {
	    return props.getProperty(key);
	}
	
}
