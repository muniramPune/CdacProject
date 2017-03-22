package com.frs.pojos;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the FRS_TBL_USER_CREDENTIALS database table.
 * 
 */
@Entity
@Table(name="FRS_TBL_USER_CREDENTIALS")
@NamedQuery(name="UserCredential.findAll", query="SELECT u FROM UserCredential u")
public class UserCredential  {
	private static final long serialVersionUID = 1L;
	private long userid;
	private String emailid;
	private int loginstatus;
	private String password;
	private String usertype;

	public UserCredential() {
	}


	@Id
	@SequenceGenerator(name="FRS_TBL_USER_CREDENTIALS_USERID_GENERATOR", sequenceName="FRS_SEQ_USER_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FRS_TBL_USER_CREDENTIALS_USERID_GENERATOR")
	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}


	public String getEmailid() {
		return this.emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}


	public int getLoginstatus() {
		return this.loginstatus;
	}

	public void setLoginstatus(int loginstatus) {
		this.loginstatus = loginstatus;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsertype() {
		return this.usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

}