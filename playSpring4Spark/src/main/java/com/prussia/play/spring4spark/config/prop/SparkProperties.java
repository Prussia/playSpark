package com.prussia.play.spring4spark.config.prop;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ConfigurationProperties(prefix = "playspring.spark")
@Getter
@Setter
@NoArgsConstructor
public class SparkProperties implements BeanClassLoaderAware, EnvironmentAware, InitializingBean {
	
	private String appName;
	private String master;
	

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnvironment(Environment environment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBeanClassLoader(ClassLoader arg0) {
		// TODO Auto-generated method stub
		
	}

}


		
