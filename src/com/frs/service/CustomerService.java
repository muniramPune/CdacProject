package com.frs.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.Map;

import com.frs.pojos.Passenger;
import com.frs.pojos.Reservation;
import com.frs.pojos.Route;
import com.frs.pojos.Schedule;
import com.frs.pojos.UserCredential;
import com.frs.pojos.UserProfile;



public interface CustomerService {
	
	public ArrayList<Route> viewByAllRoute();//Newly Added
	ArrayList<Schedule> viewScheduleByRoute(Route route, Date date);//Modified
	
	String reserveTicket(Reservation reservation, ArrayList<Passenger> passengers);
	boolean cancelTicket(String reservationId);
	Map<Reservation,Passenger> viewTicket(String reservationId);
	Map<Reservation,Passenger> printTicket(String reservationId);
	public String getDay(int i);
	
	public ArrayList<Route> viewBySource();
	
	public double totalfare(long scheduleid,int noofseats);
	public String addPassenger(ArrayList<Passenger>  passenger);
	public ArrayList<Reservation> viewByReservationId(String userid);
	
	public long generateId(Reservation reservation) ;
}
