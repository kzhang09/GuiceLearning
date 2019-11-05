package mapper;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.druid.DruidDataSourceProvider;
import util.PropertyUtil;



public class MysqlModule extends AbstractModule
{
	private String file = "mysql.properties";

	@Override
	protected void configure() {
		Names.bindProperties(binder(), PropertyUtil.loadFile(file, getClass()));

		//mysql数据库注入
		this.install(new MyBatisModule() {

			@Override
			protected void initialize() {
				bindDataSourceProviderType(DruidDataSourceProvider.class);
				bindTransactionFactoryType(JdbcTransactionFactory.class);
				// 通过属性配置完成映射,即属性的命名是遵从驼峰命名法的，数据列名遵从下划线命名
				// 会自动把 列名user_name 映射成实体userName;
				// 使用这个，同时使用注解，可以完全去除xml配置了
				mapUnderscoreToCamelCase(true);
				//类名
				addMapperClass(UserMapper.class);
				//包名
				//addMapperClasses("mapper");
				//必须要有，不然会报错
				environmentId("dev");
			}

		});
	}
}
