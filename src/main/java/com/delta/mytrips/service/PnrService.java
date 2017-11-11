package com.delta.mytrips.service;


import com.delta.mytrips.model.User;

public interface PnrService {
	
	User findPnr(String pnrNumber, String lastName, String firstName);
	
	
	
}
