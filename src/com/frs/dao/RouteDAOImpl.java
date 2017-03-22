package com.frs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frs.pojos.Route;

@Repository
public class RouteDAOImpl implements RouteDAO{

	@Autowired
	private SessionFactory sf;
	
	@Override
	public long addRoute(Route route) {
		return (long)sf.getCurrentSession().save(route);
	}

	@Override
	public boolean modifyRoute(Route route) {
		sf.getCurrentSession().saveOrUpdate(route);
		return true;
	}

	@Override
	public int removeRoute(Route route) {
System.out.println("RouteDAO removeRoute()  Route"+route);
		sf.getCurrentSession().delete(route);
		return 0;
	}

	@Override
	public ArrayList<Route> viewByRouteId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Route> viewByAllRoute() {
		
		return (ArrayList<Route>)sf.getCurrentSession().createQuery("select r from Route r").list();
	}

	@Override
	public String generateId(Route route) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Route viewByRouteId(String routeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getFair(long routeid) {
		
		String jpql="select r.fare from Route r where r.routeid=:rid";
		double fair=(double)sf.getCurrentSession().createQuery(jpql).setParameter("rid", routeid).uniqueResult();
		return fair;
	}
	
	@Override
	public List<Long> RouteIdList(){
		String jpql="select r.routeid from Route r";
		return (List<Long>)sf.getCurrentSession().createQuery(jpql).list();
	}
}
