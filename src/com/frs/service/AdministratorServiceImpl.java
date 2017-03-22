package com.frs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frs.dao.FlightDAO;
import com.frs.dao.FlightDAOImpl;
import com.frs.dao.PassengerDAO;
import com.frs.dao.PassengerDAOImpl;
import com.frs.dao.RouteDAO;
import com.frs.dao.RouteDAOImpl;
import com.frs.dao.ScheduleDAO;
import com.frs.dao.ScheduleDAOImpl;
import com.frs.pojos.Flight;
import com.frs.pojos.Passenger;
import com.frs.pojos.Route;
import com.frs.pojos.Schedule;


@Service
@Transactional
public class AdministratorServiceImpl implements AdministratorService {
	@Autowired
	private FlightDAO flightDAO;
	@Autowired
	private RouteDAO routeDAO;
	@Autowired
	private ScheduleDAO scheduleDAO;
	
	public AdministratorServiceImpl() {
		System.out.println("in AdministratorServiceImp constr ");
	}

	@Override
	public long addFlight(Flight flight) {
		
		long result=flightDAO.addFlight(flight);
		return result;
	}

	@Override
	public boolean modifyFlight(Flight flight) {
	
		boolean result=flightDAO.modifyFlight(flight);
		return result;
	}
	

	@Override
	public int removeFlight(Flight flight) {
		int result=flightDAO.removeFlight(flight);
		return result;
	}

	@Override
	public long addSchedule(Schedule schedule) {
		
		long result=scheduleDAO.addSchedule(schedule);
		return result;
	
	}

	@Override
	public boolean modifySchedule(Schedule schedule) {
		ScheduleDAO scheduleDAO=new ScheduleDAOImpl();
		boolean result=scheduleDAO.modifySchedule(schedule);
		return result;
	}

	@Override
	public int removeSchedule(List<String> scheduleId) {
		ScheduleDAO scheduleDAO=new ScheduleDAOImpl();
		//int result=scheduleDAO.removeSchedule(scheduleId);
		
		return 1;
	}

	@Override
	public long addRoute(Route route) {
		long result=routeDAO.addRoute(route);
		return result;
	}

	@Override
	public boolean modifyRoute(Route route) {
		
		boolean result=routeDAO.modifyRoute(route);
		return result;
	}

	@Override
	public int removeRoute(Route route) {
	
		int result=routeDAO.removeRoute( route);
		return result;
	}

	@Override
	public List<Flight> viewByFlightId() {
		
		List<Flight> result=flightDAO.viewByFlightId();
		return result;
	}

	@Override
	public List<Route> viewByRouteId() {
		
		List<Route> result=routeDAO.viewByRouteId();
		return result;
	}

	@Override
	public List<Flight> viewByAllFlights() {
			
		
		List<Flight> result=flightDAO.viewByAllFlights();
		return result;
	}
	

	@Override
	public List<Route> viewByAllRoute() {
		List<Route> result=routeDAO.viewByAllRoute();
		return result;
	}

	@Override
	public List<Schedule> viewByAllSchedule() {
		ScheduleDAO scheduleDAO=new ScheduleDAOImpl();
		List<Schedule> result=scheduleDAO.viewByAllSchedule();
		return result;
	}

	@Override
	public Schedule viewByScheduleId(String scheduleId) {
		ScheduleDAO scheduleDAO=new ScheduleDAOImpl();
		Schedule schedule=new Schedule();
		schedule=scheduleDAO.viewByScheduleId(scheduleId);
		return schedule;
	}

	@Override
	public List<Passenger> viewPassengersByFlight(String scheduleId) {
		PassengerDAO passengerDAO=new PassengerDAOImpl();
		List<Passenger> result=passengerDAO.viewPassengersByFlight(scheduleId);
		return result;
	}

	@Override
	public Flight viewByFlightId(String flightId) {
		FlightDAO flightDAO=new FlightDAOImpl();
		Flight flight=new Flight();
	    flight=flightDAO.viewByFlightId(flightId);
		return flight;
	}

	@Override
	public Route viewByRouteId(String routeId) {
		RouteDAO routeDAO=new RouteDAOImpl();
		Route route=new Route();
		route=routeDAO.viewByRouteId(routeId);
		return route;
		
}

	@Override
	public List<Schedule> viewByScheduleId() {
		ScheduleDAO scheduleDAO=new ScheduleDAOImpl();
		List<Schedule> result=scheduleDAO.viewByScheduleId();
		return result;
	}
	@Override
	public List<Long> FlightIdList(){
		return flightDAO.FlightIdList();
	}
	@Override
	public List<Long> RouteIdList(){
		return routeDAO.RouteIdList();
	}
}



 
