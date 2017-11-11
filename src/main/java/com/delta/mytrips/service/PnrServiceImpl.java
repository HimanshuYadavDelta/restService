package com.delta.mytrips.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.delta.mytrips.model.User;



@Service("pnrService")
public class PnrServiceImpl implements PnrService{
	
	
	private static List<User> users;
	
	static{
		users= populateDummyUsers();
	}

	public List<User> findAllUsers() {
		return users;
	}
	
	public User findPnr(String pnrNumber, String lastName, String firstName) {
		User findUser = new User(pnrNumber,firstName,lastName);
		for(User user : users){
			if(user.equals(findUser)){
				return user;
			}
		}
		return null;
	}
	
	

	private static List<User> populateDummyUsers(){
		List<User> users = new ArrayList<User>();
		users.add(new User("D3NE5A","V","Test"));
		users.add(new User("D3NE5B","V","Test"));
		users.add(new User("D3NE5C","V","Test"));
		users.add(new User("D3NE5D","V","Test"));
		users.add(new User("D3NE5E","V","Test"));
		return users;
	}

}
