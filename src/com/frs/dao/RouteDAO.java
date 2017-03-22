package com.frs.dao;

import java.util.ArrayList;
import java.util.List;

import com.frs.pojos.Route;



public interface RouteDAO {
	long addRoute(Route route);
	
	boolean modifyRoute(Route route);
	
	int removeRoute(Route routeId);
	
	public ArrayList<Route> viewByRouteId();
	
	ArrayList<Route> viewByAllRoute();
	
	public String generateId(Route route);
	
	Route viewByRouteId(String routeId);
	
	public double getFair(long routeid);
	
	
	List<Long> RouteIdList();

}
