package com.frs.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the FRS_TBL_FLIGHT database table.
 * 
 */
@Entity
@Table(name="FRS_TBL_FLIGHT")
@NamedQuery(name="Flight.findAll", query="SELECT f FROM Flight f")
public class Flight  {
	private static final long serialVersionUID = 1L;
	private long flightid;
	private String flightname;
	private int reservationcapacity;
	private int seatingcapacity;

	public Flight() {
	}


	@Id
	@SequenceGenerator(name="FRS_TBL_FLIGHT_FLIGHTID_GENERATOR", sequenceName="FRS_SEQ_FLIGHT_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FRS_TBL_FLIGHT_FLIGHTID_GENERATOR")
	public long getFlightid() {
		return this.flightid;
	}

	public void setFlightid(long flightid) {
		this.flightid = flightid;
	}


	public String getFlightname() {
		return this.flightname;
	}

	public void setFlightname(String flightname) {
		this.flightname = flightname;
	}


	public int getReservationcapacity() {
		return this.reservationcapacity;
	}

	public void setReservationcapacity(int reservationcapacity) {
		this.reservationcapacity = reservationcapacity;
	}


	public int getSeatingcapacity() {
		return this.seatingcapacity;
	}

	public void setSeatingcapacity(int seatingcapacity) {
		this.seatingcapacity = seatingcapacity;
	}

}