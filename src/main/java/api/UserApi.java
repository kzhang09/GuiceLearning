package api;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import po.User;
import redis.RedisClientTemplate;
import service.UserService;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;


@Path("/api")
@Produces(APPLICATION_JSON)
@Singleton
public class UserApi
{
	@Inject
	UserService userService;

	@Inject
	RedisClientTemplate redisClientTemplate;

//	@Inject
//	public UserApi(UserService userService)
//	{
//		this.userService = userService;
//	}

	@GET
	@Path("/users/{userId}")
	@Produces(APPLICATION_JSON)
	public Response getAssignment(
			@PathParam("userId")
			final int userId
			) {
		try {
			System.out.println(userService.getUser());

			redisClientTemplate.setex("guice_test",10,"OK");

			System.out.println(redisClientTemplate.get("guice_test"));
			return Response.ok(userService.getUser()).build();
		} catch (Exception exception) {
			throw exception;
		}

	}




}
