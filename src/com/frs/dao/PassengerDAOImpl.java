package com.frs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.sql.Date;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frs.pojos.Passenger;
import com.frs.pojos.Reservation;


@Repository
public class PassengerDAOImpl implements PassengerDAO {
@Autowired
private SessionFactory sf;

	@Override
	public ArrayList<Passenger> viewPassengersByFlight(String scheduleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Reservation, Passenger> viewTicket(String reservationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Reservation> viewByReservationId(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Reservation, Passenger> printTicket(String reservationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cancelTicket(String reservationId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getCashBack(Reservation reservation) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
