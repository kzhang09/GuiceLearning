package api;

import com.google.inject.AbstractModule;
import service.ServiceModule;

public class ApiModule extends AbstractModule
{
	@Override protected void configure()
	{
		install(new com.intuit.autumn.api.ApiModule());
		install(new ServiceModule());
	}
}
