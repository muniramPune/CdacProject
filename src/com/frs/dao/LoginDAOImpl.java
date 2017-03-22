package com.frs.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frs.pojos.UserCredential;
import com.frs.pojos.UserProfile;
@Repository
public class LoginDAOImpl implements LoginDao {
	@Autowired
	private SessionFactory sf;
	
	@Override
	public UserCredential login(String emailid, String password) {
		String jpql="select u from UserCredential u where u.emailid= :email and u.password= :pass";
		
		System.out.println("Login dao Email password"+emailid+password);
		
		System.out.println("login() DAO:"+(UserCredential)sf.getCurrentSession().createQuery(jpql).
				setParameter("email", emailid).setParameter("pass", password).uniqueResult());
		System.out.println("login() DAO:"+sf.getCurrentSession().createQuery("select u from UserCredential u").list());
			
		return (UserCredential)sf.getCurrentSession().createQuery(jpql).
				setParameter("email", emailid).setParameter("pass", password).uniqueResult();

	}

	@Override
	public UserProfile register(UserProfile user,UserCredential u) {
		
		System.out.println("UserProfile dao"+user+u);
		long id=(long)sf.getCurrentSession().save(u);
		user.setUserid(id);
		sf.getCurrentSession().save(user);
		return user;
	}

	@Override
	public long getIdByEmail(String email) {
		// TODO Auto-generated method stub
		return 0;
	}

}
