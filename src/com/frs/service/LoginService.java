package com.frs.service;
import com.frs.pojos.*;
public interface LoginService {
	
	UserCredential login(String emailid,String password);
	UserProfile register(UserProfile user,UserCredential u);
	long getIdByEmail(String email);
	
}
