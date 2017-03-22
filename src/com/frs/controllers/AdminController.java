package com.frs.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.frs.pojos.Flight;
import com.frs.pojos.Route;
import com.frs.pojos.Schedule;
import com.frs.service.AdministratorService;

@Controller
// mandatory
@RequestMapping("/admin")
// optional
public class AdminController {
	@Autowired
	private AdministratorService service;


	public AdminController() {
		System.out.println("in controllr constr ");
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		System.out.println("in init");
	}

	// controller method to display reg form
	@RequestMapping(value = "/addFlight")
	public String showflightForm(Flight flight) {
		System.out.println("in show reg form " + flight);
		// map.addAttribute(new Customer());
		return "addFlight";
	}

	@RequestMapping(value = "/addFlight", method = RequestMethod.POST)
	public String processflightForm(Flight flight, Model map, HttpSession hs) {
		System.out.println("in process addFlight");
		System.out.println("flight details " + flight);
		// invoke service layer method
		Long status = service.addFlight(flight);
		if (status == null) {
			map.addAttribute("mesg", "Flight not added , Pls retry");
			return "addFlight";
		}
		hs.setAttribute("flightId", status);
		hs.setAttribute("status", "Flight Added Successful");
		return "Admin";// replace forward by redirect
	}



	@RequestMapping(value = "/ViewAllFlight")
	public String ViewByAllFlight(Model map) {
		List<Flight> flight=service.viewByAllFlights();
		map.addAttribute("viewflight", flight);
		return "ViewAllFlight";
	}	

	//modifyflight
	//deleteflight
	@RequestMapping(value = "/ModifyFlight")
	public String modefyFlight(Flight flight,Model map) {
		System.out.println("in show modefyFlight1 form " + flight);
		map.addAttribute("listValue", flight);
		return "ModifyFlight";
	}
	@RequestMapping(value = "/ModifyFlight", method = RequestMethod.POST)
	public String modefyFlight1(@ModelAttribute("listValue") Flight flight,Model map,HttpServletRequest req) {
		System.out.println("in Process modefyFlight form " + flight);
		System.out.println("Request param "+req.getParameter("flightid")+req.getParameter("flightname")+req.getParameter("seatingcapacity")+req.getParameter("reservationcapacity"));
		service.modifyFlight(flight);
		return "aa";
	}
	@RequestMapping(value = "/deleteFlight")

	public String deleteFlight(Flight flight,Model map) {
		System.out.println("in deleteFlight  " + flight);
		service.removeFlight(flight);
		return "aa";
	}


	@RequestMapping(value = "/addroute")
	public String showrouteForm(Route route) {
		return "addRoute";
	}	


	@RequestMapping(value = "/addroute", method = RequestMethod.POST)
	public String processrouteForm(Route route, Model map, HttpSession hs) {
		System.out.println("in process addroute");
		System.out.println("Route details " + route);
		// invoke service layer method
		long status = service.addRoute(route);
		if (status==0) {
			map.addAttribute("mesg", "Route not added , Pls retry");
			return "addRoute";
		}
		hs.setAttribute("RouteId", status);
		hs.setAttribute("status", "Route Added Successful");
		return "Admin";// replace forward by redirect
	}


	@RequestMapping(value = "/ViewAllRoutes")
	public String ViewByAllRoute(Model map) {
		List<Route> route=service.viewByAllRoute();
		System.out.println(route);
		map.addAttribute("view",route);
		return "ViewAllRoute";
	}	
	//modifyroute
	//deleteroute
	@RequestMapping(value = "/ModifyRoute")
	public String modifyRoute(Route route,Model map) {
		System.out.println("in show modefyRoute " + route);
		map.addAttribute("listValue", route);
		return "ModifyRoute";
	}

	@RequestMapping(value = "/ModifyRoute", method = RequestMethod.POST)
	public String modifyRoute(Route route,Model map,HttpServletRequest req) {
		System.out.println("in Process modefyroute form " + route);

		service.modifyRoute(route);
		return "bb";
	}

	@RequestMapping(value = "/deleteRoute")
	public String deleteRoute(Route route,Model map) {
		System.out.println("in deleteroute  " + route);
		service.removeRoute(route);
		return "bb";
	}

	//------------------------------------------
	@RequestMapping(value = "/addschedule")
	public String showscheduleForm(Schedule schedule,Model map) {
		List<Long> fid=service.FlightIdList();
		List<Long> rid=service.RouteIdList();
		System.out.println(rid);
		map.addAttribute("fid",fid);
		map.addAttribute("rid", rid);
		return "addSchedule";
	}	


	@RequestMapping(value = "/addschedule", method = RequestMethod.POST)
	public String processscheduleForm(Schedule schedule, Model map, HttpSession hs) {
		System.out.println("in process addschedule");
		System.out.println("Schedule Details " + schedule);

		long status = service.addSchedule(schedule);
		if (status==0) {
			map.addAttribute("mesg", "Schedule not added , Pls retry");
			return "addSchedule";
		}
		hs.setAttribute("ScheduleId", status);
		hs.setAttribute("status", "Schedule Added Successful");
		return "Admin";// replace forward by redirect
	}


	@RequestMapping(value = "/ViewAllSchedule")
	public String ViewByAlloute(Model map) {
		List<Route> route=service.viewByAllRoute();
		System.out.println(route);
		map.addAttribute("view",route);
		return "ViewAllRoute";
	}	

}