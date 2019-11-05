package service;

import po.User;

import java.util.List;

public interface UserService
{

	List<User> getUser();


	User getUserByName(String userName);


	User getUserByAge(int age);



}
