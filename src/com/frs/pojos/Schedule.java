package com.frs.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the FRS_TBL_SCHEDULE database table.
 * 
 */
@Entity
@Table(name="FRS_TBL_SCHEDULE")
@NamedQuery(name="Schedule.findAll", query="SELECT s FROM Schedule s")
public class Schedule  {
	private static final long serialVersionUID = 1L;
	private long scheduleid;
	private String availabledays;
	private String departuretime;
	private long flightid;
	private long routeid;
	private String travelduration;
	private int seatavailablecount;
	
	public int getSeatavailablecount() {
		return seatavailablecount;
	}


	public void setSeatavailablecount(int seatavailablecount) {
		this.seatavailablecount = seatavailablecount;
	}


	public Schedule() {
	}


	@Id
	@SequenceGenerator(name="FRS_TBL_SCHEDULE_SCHEDULEID_GENERATOR", sequenceName="FRS_SEQ_SCHEDULE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FRS_TBL_SCHEDULE_SCHEDULEID_GENERATOR")
	public long getScheduleid() {
		return this.scheduleid;
	}

	public void setScheduleid(long scheduleid) {
		this.scheduleid = scheduleid;
	}


	public String getAvailabledays() {
		return this.availabledays;
	}

	public void setAvailabledays(String availabledays) {
		this.availabledays = availabledays;
	}


	public String getDeparturetime() {
		return this.departuretime;
	}

	public void setDeparturetime(String departuretime) {
		this.departuretime = departuretime;
	}


	public long getFlightid() {
		return this.flightid;
	}

	public void setFlightid(long flightid) {
		this.flightid = flightid;
	}


	public long getRouteid() {
		return this.routeid;
	}

	public void setRouteid(long routeid) {
		this.routeid = routeid;
	}


	public String getTravelduration() {
		return this.travelduration;
	}

	public void setTravelduration(String travelduration) {
		this.travelduration = travelduration;
	}


	@Override
	public String toString() {
		return "Schedule [scheduleid=" + scheduleid + ", availabledays="
				+ availabledays + ", departuretime=" + departuretime
				+ ", flightid=" + flightid + ", routeid=" + routeid
				+ ", travelduration=" + travelduration + "]";
	}

	
}