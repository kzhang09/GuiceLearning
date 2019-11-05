

import api.ApiModule;
import com.google.inject.Inject;
import com.intuit.autumn.service.ServiceManager;
import mapper.MysqlModule;
import redis.RedisModule;
import service.UserService;
import static com.intuit.autumn.web.WebServices.getEnabledWebServices;

public class Main {


	private Main() {
	}

	@Inject
	UserService userService;

	/**
	 * Application entry point.
	 *
	 * @param args application arguments
	 * @throws Exception unintended exception
	 */

	public static void main(String[] args) throws Exception {
		ServiceManager serviceManager = new ServiceManager()
				.addModules(MysqlModule.class,  ApiModule.class, RedisModule.class)
				.addServices(getEnabledWebServices());

		//项目启动
		serviceManager.start();
	}

}
