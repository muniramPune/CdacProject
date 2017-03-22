package com.frs.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the FRS_TBL_RESERVATION database table.
 * 
 */
@Entity
@Table(name="FRS_TBL_RESERVATION")
@NamedQuery(name="Reservation.findAll", query="SELECT r FROM Reservation r")
public class Reservation  {
	private static final long serialVersionUID = 1L;
	private long reservationid;
	private Date bookingdate;
	private int bookingstatus;
	private Date journeydate;
	private int noofseats;
	private String reservationtype;
	private long scheduleid;
	private double totalfare;
	private long userid;

	public Reservation() {
	}


	@Id
	@SequenceGenerator(name="FRS_TBL_RESERVATION_RESERVATIONID_GENERATOR", sequenceName="FRS_SEQ_RESERVATION_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FRS_TBL_RESERVATION_RESERVATIONID_GENERATOR")
	public long getReservationid() {
		return this.reservationid;
	}

	public void setReservationid(long reservationid) {
		this.reservationid = reservationid;
	}


	@Temporal(TemporalType.DATE)
	public Date getBookingdate() {
		return this.bookingdate;
	}

	public void setBookingdate(Date bookingdate) {
		this.bookingdate = bookingdate;
	}


	public int getBookingstatus() {
		return this.bookingstatus;
	}

	public void setBookingstatus(int bookingstatus) {
		this.bookingstatus = bookingstatus;
	}


	@Temporal(TemporalType.DATE)
	public Date getJourneydate() {
		return this.journeydate;
	}

	public void setJourneydate(Date journeydate) {
		this.journeydate = journeydate;
	}


	public int getNoofseats() {
		return this.noofseats;
	}

	public void setNoofseats(int noofseats) {
		this.noofseats = noofseats;
	}


	public String getReservationtype() {
		return this.reservationtype;
	}

	public void setReservationtype(String reservationtype) {
		this.reservationtype = reservationtype;
	}


	public long getScheduleid() {
		return this.scheduleid;
	}

	public void setScheduleid(long scheduleid) {
		this.scheduleid = scheduleid;
	}


	public double getTotalfare() {
		return this.totalfare;
	}

	public void setTotalfare(double totalfare) {
		this.totalfare = totalfare;
	}


	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}


	@Override
	public String toString() {
		return "Reservation [reservationid=" + reservationid + ", bookingdate="
				+ bookingdate + ", bookingstatus=" + bookingstatus
				+ ", journeydate=" + journeydate + ", noofseats=" + noofseats
				+ ", reservationtype=" + reservationtype + ", scheduleid="
				+ scheduleid + ", totalfare=" + totalfare + ", userid="
				+ userid + "]";
	}

}