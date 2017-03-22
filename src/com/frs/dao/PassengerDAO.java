package com.frs.dao;

import java.util.ArrayList;
import java.util.Map;

import com.frs.pojos.Passenger;
import com.frs.pojos.Reservation;


public interface PassengerDAO {
	public ArrayList<Passenger> viewPassengersByFlight(String scheduleId);
	public Map<Reservation, Passenger> viewTicket(String reservationId);
	public ArrayList<Reservation> viewByReservationId(String userid);
	public Map<Reservation, Passenger> printTicket(String reservationId);
	public boolean cancelTicket(String reservationId);
	public boolean getCashBack(Reservation reservation);
}
