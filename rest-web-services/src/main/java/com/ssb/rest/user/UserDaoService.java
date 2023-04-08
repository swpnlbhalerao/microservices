package com.ssb.rest.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	
	
	private static List<User> userList = new ArrayList<User>();
	
	private static int userCount = 1;
	static {
		userList.add(new User(userCount++, "Swapnil", LocalDate.now().minusYears(21).toString()));
		userList.add(new User(userCount++,"Pallavi", LocalDate.now().minusYears(11).toString()));
		userList.add(new User(userCount++, "Padma", LocalDate.now().minusYears(22).toString()));
	
	}
	
	
	
	public List<User> getAllUser(){
		return userList;
	}
	
	public User findOne(int id){
		
		return userList.stream().filter(user -> user.getId()==id).findFirst().orElse(null);
	}
	
	public User save(User user) {
		user.setId(userCount++);
		userList.add(user);
		return user;
	}
	
}
