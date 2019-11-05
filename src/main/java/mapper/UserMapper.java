package mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import po.User;

import java.util.List;

public interface UserMapper
{

	@Select("SELECT * FROM user WHERE user_name = #{userName}")
	User getUserByName(@Param("userName") String userName);


	@Select("SELECT * FROM user WHERE age = #{arg0}")
	User getUserByAge(int age);


	@Select("SELECT * FROM user ")
	List<User> getUsers();

}
