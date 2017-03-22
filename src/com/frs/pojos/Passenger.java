package com.frs.pojos;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the FRS_TBL_PASSENGER database table.
 * 
 */
@Entity
@Table(name="FRS_TBL_PASSENGER")
@NamedQuery(name="Passenger.findAll", query="SELECT p FROM Passenger p")
public class Passenger  {
	private static final long serialVersionUID = 1L;
	private int age;
	private String gender;
	private String name;
	private long reservationid;
	private long seatno;

	public Passenger() {
	}


	public Passenger(int age, String gender, String name, long reservationid) {

		this.age = age;
		this.gender = gender;
		this.name = name;
		this.reservationid = reservationid;
	}

	
	@Id
	@SequenceGenerator(name="FRS_SEQ_SEATNO_GENERATOR", sequenceName="FRS_SEQ_SEATNO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FRS_SEQ_SEATNO_GENERATOR")
	
	public long getSeatno() {
		return this.seatno;
	}

	public void setSeatno(long seatno) {
		this.seatno = seatno;
	}


	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public long getReservationid() {
		return this.reservationid;
	}

	public void setReservationid(long reservationid) {
		this.reservationid = reservationid;
	}



	@Override
	public String toString() {
		return "Passenger [age=" + age + ", gender=" + gender + ", name="
				+ name + ", reservationid=" + reservationid + ", seatno="
				+ seatno + "]";
	}

	
}