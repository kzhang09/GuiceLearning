package service.impl;

import com.google.inject.Inject;
import mapper.UserMapper;
import po.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService
{

	//注入
	@Inject
	UserMapper userMapper;


	@Override public List<User> getUser()
	{
		return userMapper.getUsers();
	}

	@Override public User getUserByName(String userName)
	{
		return userMapper.getUserByName(userName);
	}

	@Override public User getUserByAge(int age)
	{
		return userMapper.getUserByAge(age);
	}
}
