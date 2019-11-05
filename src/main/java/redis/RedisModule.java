package redis;


import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;
import util.PropertyUtil;

public class RedisModule extends AbstractModule
{
	private String file = "redis.properties";
	@Override protected void configure()
	{
		System.out.println("installing module: {}"+ RedisModule.class.getSimpleName());
		Names.bindProperties(binder(), PropertyUtil.loadFile(file, getClass()));

		//绑定redis数据源
		bind(RedisDataSource.class).toProvider(RedisClientProvider.class).in(Scopes.SINGLETON);
	}
}
