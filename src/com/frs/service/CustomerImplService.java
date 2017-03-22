package com.frs.service;


import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frs.dao.LoginDao;
import com.frs.dao.PassengerDAO;
import com.frs.dao.PassengerDAOImpl;
import com.frs.dao.ReservationDAO;
import com.frs.dao.ReservationDAOImpl;
import com.frs.dao.RouteDAO;
import com.frs.dao.ScheduleDAO;
import com.frs.pojos.Passenger;
import com.frs.pojos.Reservation;
import com.frs.pojos.Route;
import com.frs.pojos.Schedule;
import com.frs.pojos.UserCredential;
import com.frs.pojos.UserProfile;


@Service
@Transactional
public class CustomerImplService implements CustomerService {

	@Autowired
	private ReservationDAO reservationDAO;
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private RouteDAO routeDao;
	@Autowired
	private ScheduleDAO scheduleDao;
	@Autowired
	private PassengerDAO passengerDAO;

	public CustomerImplService() {
		System.out.println("in CustomerImplService constr ");
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Route> viewByAllRoute() {

		return routeDao.viewByAllRoute();
	}

	@Override
	public ArrayList<Schedule> viewScheduleByRoute(Route route, Date date) {
		System.out.println("in viewScheduleByRoute()  date"+date);
		ArrayList<Schedule> result=reservationDAO.viewScheduleByRoute(route, date);
		return result;
	}

	
	
	@Override
	public String reserveTicket(Reservation reservation, ArrayList<Passenger> passengers) {
		
		String result=reservationDAO.reserveTicket(reservation, passengers);
		return result;
	}

	
	
	
	
	@Override
	public boolean cancelTicket(String reservationId) {
		//Reservation reservation=new Reservation();

		
		boolean result=passengerDAO.cancelTicket(reservationId);
		return result;
	}

	@Override
	public Map<Reservation, Passenger> viewTicket(String reservationId) {
		
		Map<Reservation,Passenger>  result=passengerDAO.viewTicket(reservationId);
		return result;
	}

	@Override
	public Map<Reservation, Passenger> printTicket(String reservationId) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ArrayList<Route> viewBySource() {

		ArrayList<Route> result=reservationDAO.viewBySource();
		return result;
	}

	@Override
	public String getDay(int i)
	{
		switch (i) {
		case 0:
			return "sunday";

		case 1:
			return "monday";
		case 2:
			return "tuesday";
		case 3:
			return "wednesday";
		case 4:
			return "thursday";
		case 5:
			return "friday";
		case 6:
			return "saturday";
		}

		return null;
	}

	@Override
	public double totalfare(long scheduleid, int noofseats) {
		double totalfare=0.0;
		long routeid=scheduleDao.getRoutId(scheduleid);
		double fare=routeDao.getFair(routeid);
		totalfare=fare*noofseats;
		return totalfare;

	}

	@Override
	public String addPassenger(ArrayList<Passenger>  passenger) {
		ReservationDAO reservationDAO=new ReservationDAOImpl();
		String result=reservationDAO.addPassenger(passenger);
		return result;
	}

	@Override
	public ArrayList<Reservation> viewByReservationId(String userid) {
		PassengerDAO passengerDAO=new PassengerDAOImpl();
		ArrayList<Reservation> result=passengerDAO.viewByReservationId(userid);
		return result;
	}

	@Override
	public long generateId(Reservation reservation) {		
		return reservationDAO.generateId(reservation);
	}


}
