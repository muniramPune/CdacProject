package com.frs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frs.pojos.Schedule;


@Repository
public class ScheduleDAOImpl implements ScheduleDAO {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public long addSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean modifySchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int removeSchedule(ArrayList<String> scheduleId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Schedule> viewByAllSchedule() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateId(Schedule schedule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Schedule viewByScheduleId(String scheduleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Schedule> viewByScheduleId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getRoutId(long scheduleId) {
		long routeid=(Long) sf.getCurrentSession().createQuery("select s.routeid from Schedule s where s.scheduleid=:schid").setParameter("schid", scheduleId).uniqueResult();
		return routeid;
	}
	


}
