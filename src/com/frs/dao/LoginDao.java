package com.frs.dao;

import com.frs.pojos.UserCredential;
import com.frs.pojos.UserProfile;

public interface LoginDao {

	UserCredential login(String emailid,String password);
	
	UserProfile register(UserProfile user,UserCredential u);
	public long getIdByEmail(String email);
}
