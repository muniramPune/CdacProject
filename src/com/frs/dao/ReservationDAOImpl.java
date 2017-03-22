package com.frs.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frs.pojos.Passenger;
import com.frs.pojos.Reservation;
import com.frs.pojos.Route;
import com.frs.pojos.Schedule;


@Repository
public class ReservationDAOImpl implements ReservationDAO{

	@Autowired
	private SessionFactory sf;

	@Override
	public ArrayList<Schedule> viewScheduleByRoute(Route route, Date date) {
		System.out.println("Date in Dao "+date);
		String day=null;
		switch (date.getDay()) {
		case 0:
			day= "Sun";
			break;

		case 1:
			day= "Mon";
			break;
		case 2:
			day= "Tue";
			break;
		case 3:
			day="Wed";
			break;
		case 4:
			day= "Thu";
			break;
		case 5:
			day= "friday";
		case 6:
			day= "saturday";
		}
		String jpql="select s from Schedule s where s.availabledays like '%"+day+"%'";
		return (ArrayList<Schedule>)sf.getCurrentSession().createQuery(jpql).list();

	}

	@Override
	public ArrayList<Route> viewBySource() {
		ArrayList<Route> routelist=new ArrayList<Route>();

		routelist=(ArrayList<Route>)sf.getCurrentSession().createQuery("select r from Route r").list();
		System.out.println("ReservationDAO viewBySource() routelist"+routelist);
		return routelist;

	}

	@Override
	public String reserveTicket(Reservation reservation,ArrayList<Passenger> passengers) {
		String status="Passenger Entry in DB failed";
		System.out.println("in Reservation Dao reserveTicke() reservation"+reservation);
		System.out.println("in Reservation Dao reserveTicke() passengers"+passengers);
		long seatno=0;
		for (Passenger passenger : passengers) {
			 seatno=(Long)sf.getCurrentSession().save(passenger);
		}
		if(seatno>0)
			status="Successfully Reserved";
		
		return status;
	}

	@Override
	public boolean cancelTicket(String reservationId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long generateId(Reservation reservation) {

		return (Long)sf.getCurrentSession().save(reservation);
	}

	@Override
	public String addPassenger(List<Passenger> passenger) {
		// TODO Auto-generated method stub
		return null;
	}

}
