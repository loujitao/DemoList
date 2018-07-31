package com.teleinfo.filter;


import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public final class PropertiesUtils{
	//文件路径
	private static final String[] CFG_PATHS = new String[]{"/app.properties"};
	//实例
	private static PropertiesUtils instance;
	private Resource resource = null;
	private Properties props = null;

	private synchronized void refresh() {
		if(null != props) {
			props.clear();
		}
		for(String path : CFG_PATHS ) {
			try {
				resource = new ClassPathResource(path);
				if(null == props) {
					props = PropertiesLoaderUtils.loadProperties(resource);
				} else {
					props.putAll(PropertiesLoaderUtils.loadProperties(resource));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static synchronized void checkInstance() {
		if(instance == null) {
			synchronized(CFG_PATHS) {
				if(instance == null) {
					instance = new PropertiesUtils();
				}
			}
		}
	}

	public static String getProperty(String key) {
		checkInstance();
		return instance.props.getProperty(key);
	}

	public static void setProperty(String key, String value) {
		checkInstance();
		instance.props.setProperty(key, value);
	}

	public static String getProperty(String key, String defStr) {
		checkInstance();
		return instance.props.getProperty(key, defStr);
	}

	private PropertiesUtils() {
		super();
		refresh();
	}
	
	
}
