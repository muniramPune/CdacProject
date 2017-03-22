package com.frs.dao;

import java.util.List;

import com.frs.pojos.Flight;



public interface FlightDAO {
	long addFlight(Flight Flight);
	boolean modifyFlight(Flight Flight);
	int removeFlight(Flight flight);
	public List<Flight> viewByFlightId();
	public String generateId(Flight Flight);
	List<Flight> viewByAllFlights();
	Flight viewByFlightId(String flightId);
	public List<Long> FlightIdList();

}
