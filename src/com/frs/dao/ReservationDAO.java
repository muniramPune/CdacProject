package com.frs.dao;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import com.frs.pojos.Passenger;
import com.frs.pojos.Reservation;
import com.frs.pojos.Route;
import com.frs.pojos.Schedule;



public interface ReservationDAO {

	public ArrayList<Schedule> viewScheduleByRoute(Route route, java.util.Date date);
	
	public ArrayList<Route> viewBySource();
	
	public String reserveTicket(Reservation reservation, ArrayList<Passenger> passengers);
	
	public boolean cancelTicket(String reservationId);
	
	public long generateId(Reservation reservation);
	
	public String addPassenger(List<Passenger>  passenger);
}
