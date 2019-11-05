package service;

import com.google.inject.AbstractModule;
import service.impl.UserServiceImpl;


public class ServiceModule extends AbstractModule
{

	public static final String PROPERTY_NAME = "/web.properties";


	@Override protected void configure()
	{
		//server服务注入
		bind(UserService.class).to(UserServiceImpl.class);
	}
}
