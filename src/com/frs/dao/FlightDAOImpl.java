package com.frs.dao;


import java.util.List;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frs.pojos.Flight;
import com.frs.pojos.UserCredential;


@Repository
public class FlightDAOImpl implements FlightDAO {
	@Autowired
	private SessionFactory sf;
	
	
	@Override
	public long addFlight(Flight flight) {
		
		System.out.println("addFlight()"+sf);
		return (long)sf.getCurrentSession().save(flight);
		
	}

	@Override
	public boolean modifyFlight(Flight Flight) {
		sf.getCurrentSession().saveOrUpdate(Flight);
		return true;
	}

	@Override
	public int removeFlight(Flight flight) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().delete(flight);
		return 0;
	}

	@Override
	public List<Flight> viewByFlightId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateId(Flight Flight) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flight> viewByAllFlights() {
		//List<Flight> flight=new List<Flight>();
		String jpql="select f from Flight f";
		System.out.println("flight database"+(List<Flight>)sf.getCurrentSession().createQuery(jpql).list());
		return (List<Flight>)sf.getCurrentSession().createQuery(jpql).list();

		
	}

	@Override
	public Flight viewByFlightId(String flightId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Long> FlightIdList(){
		String jpql="select f.flightid from Flight f";
		return (List<Long>)sf.getCurrentSession().createQuery(jpql).list();
	}
	
}
