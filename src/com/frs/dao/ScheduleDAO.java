package com.frs.dao;

import java.util.ArrayList;

import com.frs.pojos.Schedule;



public interface ScheduleDAO {
	long addSchedule(Schedule schedule);
	
	boolean modifySchedule(Schedule schedule);
	
	int removeSchedule(ArrayList<String> scheduleId);
    ArrayList<Schedule> viewByAllSchedule();
    public String generateId(Schedule schedule);
	Schedule viewByScheduleId(String scheduleId);
	 public ArrayList<Schedule> viewByScheduleId();
	 
	 public long getRoutId(long scheduleId);
}
