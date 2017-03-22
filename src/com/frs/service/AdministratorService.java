package com.frs.service;


import java.util.List;

import com.frs.pojos.Flight;
import com.frs.pojos.Passenger;
import com.frs.pojos.Route;
import com.frs.pojos.Schedule;



public interface AdministratorService {
	long addFlight(Flight flight);
	boolean modifyFlight(Flight flight);
	int removeFlight(Flight flight);

	long addSchedule(Schedule schedule);
	boolean modifySchedule(Schedule schedule);
	int removeSchedule(List<String> scheduleId);

	long addRoute(Route route);
	boolean modifyRoute(Route route);
	int removeRoute(Route route);

	List<Flight> viewByFlightId();

	public List<Route> viewByRouteId();
	public List<Schedule> viewByScheduleId();
	List<Flight> viewByAllFlights();
	
	List<Route> viewByAllRoute();
	
	List<Schedule> viewByAllSchedule();

	public Schedule viewByScheduleId(String scheduleId);

	List<Passenger> viewPassengersByFlight(String scheduleId);
	public Flight viewByFlightId(String flightId);
	public Route viewByRouteId(String routeId);
	public List<Long> FlightIdList();
	public List<Long> RouteIdList();
}
