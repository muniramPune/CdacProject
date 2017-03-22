package com.frs.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the FRS_TBL_CREDITCARD database table.
 * 
 */
@Entity
@Table(name="FRS_TBL_CREDITCARD")
@NamedQuery(name="Creditcard.findAll", query="SELECT c FROM Creditcard c")
public class Creditcard  {
	private static final long serialVersionUID = 1L;
	private long creditcardnumber;
	private double creditbalance;
	private long userid;
	private String validfrom;
	private String validto;

	public Creditcard() {
	}


	@Id
	public long getCreditcardnumber() {
		return this.creditcardnumber;
	}

	public void setCreditcardnumber(long creditcardnumber) {
		this.creditcardnumber = creditcardnumber;
	}


	public double getCreditbalance() {
		return this.creditbalance;
	}

	public void setCreditbalance(double creditbalance) {
		this.creditbalance = creditbalance;
	}


	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}


	public String getValidfrom() {
		return this.validfrom;
	}

	public void setValidfrom(String validfrom) {
		this.validfrom = validfrom;
	}


	public String getValidto() {
		return this.validto;
	}

	public void setValidto(String validto) {
		this.validto = validto;
	}

}