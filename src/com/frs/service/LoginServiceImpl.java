package com.frs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frs.dao.LoginDao;
import com.frs.pojos.UserCredential;
import com.frs.pojos.UserProfile;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;

	@Override
	public UserCredential login(String emailid, String password) {
		System.out.println("LoginService login()"+emailid+password);
		
		return loginDao.login(emailid, password);
	}

	@Override
	public UserProfile register(UserProfile user,UserCredential u) {
		
		System.out.println(" in UserProfile "+user);
		return loginDao.register(user,u);
	}

	@Override
	public long getIdByEmail(String email) {
		
		return loginDao.getIdByEmail(email);
	}

}
