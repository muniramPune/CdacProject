package com.frs.controllers;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.frs.pojos.Flight;
import com.frs.pojos.Passenger;
import com.frs.pojos.Reservation;
import com.frs.pojos.Route;
import com.frs.pojos.Schedule;
import com.frs.pojos.UserCredential;
import com.frs.pojos.UserProfile;
import com.frs.service.AdministratorService;
import com.frs.service.CustomerService;

@Controller
// mandatory
@RequestMapping("/customer")
// optional
public class CustomerController {
	@Autowired
	private CustomerService custService;	


	public CustomerController() {
		System.out.println("in cust controllr constr ");
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		System.out.println("in cust init");
	}

	// controller method to display reg form
	@RequestMapping(value = "/register")
	public String showRegForm(UserProfile userProfile) {
		System.out.println("in show reg form " + userProfile);
		// map.addAttribute(new Customer());
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegForm(UserProfile userProfile, Model map, HttpSession hs) {


		return "redirect:/valid";// replace forward by redirect
	}

	@RequestMapping(value = "/reservationsource")
	public String showReservationSource(Route route,Model map,HttpSession hs) {
		System.out.println("in show Reservation Source form " + route);

		ArrayList<Route> routeList=custService.viewBySource();
		Map<String,String> source = new LinkedHashMap<String,String>();
		Map<String,String> destination = new LinkedHashMap<String,String>();
		for (Route route2 : routeList) {
			source.put(route2.getSource(), route2.getSource());
			destination.put(route2.getDestination(),route2.getDestination());
		}
		map.addAttribute("source",source);
		map.addAttribute("destination",destination);

		return "ReservationSource";
	}

	@RequestMapping(value = "/reservationsource", method = RequestMethod.POST)
	public String processReservationSource(Route route, Model map, HttpSession hs,HttpServletRequest request) {
		System.out.println("route "+route.getSource()+route.getDestination());
		System.out.println("date"+request.getParameter("date"));
		hs.setAttribute("journeydate", request.getParameter("date"));
		/*DateFormat formatter;
	      formatter = new SimpleDateFormat("dd-MMM-yyyy");
	      Date date = (Date) formatter.parse(request.getParameter("date"));
		 */
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yy");

		try {
			System.out.println("Controller ScheduleList"+custService.viewScheduleByRoute(route, sdf.parse(request.getParameter("date"))));

			map.addAttribute("scheduleList",custService.viewScheduleByRoute(route, sdf.parse(request.getParameter("date"))));
		} catch (ParseException e) {
			System.out.println("Parse Error in process Reservation Source() in Cust Controller");
			e.printStackTrace();
		}
		map.addAttribute("routeList",custService.viewByAllRoute());
		return "ReservationFlight";		
		//return "redirect:/valid";// replace forward by redirect

	}

	@RequestMapping(value = "/ReserveTicket")
	public String showReserveTicket(Reservation reservation,Model map,HttpSession hs,HttpServletRequest request) {
		System.out.println("in show ReserveTicket form " + reservation);

		System.out.println("scheduleid"+request.getParameter("scheduleid"));
		long scheduleid=new Long(request.getParameter("scheduleid"));

		map.addAttribute("scheduleid",scheduleid);
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yy");
		java.util.Date now=new java.util.Date();

		System.out.println(sdf.format(now));

		map.addAttribute("now",sdf.format(now));
		return "ReserveTicket";
	}

	@RequestMapping(value = "/ReserveTicket", method = RequestMethod.POST)
	public String processReserveTicket(Reservation reservation, Model map, HttpSession hs,HttpServletRequest request) {
		System.out.println("processReserveticket() post");
		System.out.println("Schedule ProcessReserveTicket Form"+reservation);
		ArrayList<Route> routeList= custService.viewByAllRoute();

		double totalfare=custService.totalfare(reservation.getScheduleid(), reservation.getNoofseats());
		reservation.setTotalfare(totalfare);

		long reservationid=custService.generateId(reservation);
		reservation.setReservationid(reservationid);
		map.addAttribute("reservationid",reservationid);
		hs.setAttribute("reservation", reservation);
		return "PassengerDetails";		
		//return "redirect:/valid";

	}


	@RequestMapping(value = "/PassengerDetails")
	public String showAddPassengerDetails(Reservation reservation,Model map,HttpSession hs,HttpServletRequest request) {
		System.out.println("in show AddPassengerDetails form " + reservation);

		System.out.println("scheduleid"+request.getParameter("scheduleid"));
		return "PassengerDetails";
	}

	@RequestMapping(value = "/PassengerDetails", method = RequestMethod.POST)
	public String processAddPassengerDetails( Model map, HttpSession hs,HttpServletRequest request) {
		System.out.println("processaddpassengerDetails() post");
		//System.out.println("Schedule ProcessReserveTicket Form"+reservation);
		Reservation reservation=(Reservation)hs.getAttribute("reservation");

		ArrayList<Passenger> passengerList=new ArrayList<Passenger>();
		int noofseats=reservation.getNoofseats();

		for(int i=0;i<noofseats;i++)
		{
			/*int age, String gender, String name, long reservationid*/
			int age=Integer.parseInt(request.getParameter("age"+i));
			String gender=request.getParameter("gender"+i);
			String name=request.getParameter("name"+i);
			Passenger p1=new Passenger(age, gender, name, reservation.getReservationid());
			passengerList.add(p1);
			System.out.println("in for() addPassengeDetails Passenger1"+p1);
		}

		String status=custService.reserveTicket(reservation, passengerList);

		map.addAttribute("passengerlist",passengerList);
		map.addAttribute("status",status);

		return "MakePayment";		
		//return "redirect:/valid";

	}

	@RequestMapping(value = "/MakePayment")
	public String showMakePayment(Reservation reservation,Model map,HttpSession hs,HttpServletRequest request) {
		System.out.println("in show MakePayment form " + reservation);

		System.out.println("scheduleid"+hs.getAttribute("reservation"));
		System.out.println("scheduleid"+hs.getAttribute("userid"));
		return "MakePayment";
	}

	@RequestMapping(value = "/MakePayment", method = RequestMethod.POST)
	public String processMakePayment( Model map, HttpSession hs,HttpServletRequest request) {
		System.out.println("processMakePayment() post");
		//System.out.println("Schedule ProcessReserveTicket Form"+reservation);
		Reservation reservation=(Reservation)hs.getAttribute("reservation");
		
		return "SuccessfulProcess";		
		//return "redirect:/valid";

	}

	@RequestMapping(value = "/SuccessfulProcess")
	public String showSuccessfulProcess(Reservation reservation,Model map,HttpSession hs,HttpServletRequest request) {
		System.out.println("in show SuccessfulProcess form " + reservation);

		System.out.println("scheduleid"+hs.getAttribute("reservation"));
		System.out.println("scheduleid"+hs.getAttribute("userid"));
		return "SuccessfulProcess";
	}

	@RequestMapping(value = "/SuccessfulProcess", method = RequestMethod.POST)
	public String processSuccessfulProcess( Model map, HttpSession hs,HttpServletRequest request) {
		System.out.println("SuccessfulProcess() post");
		//System.out.println("Schedule ProcessReserveTicket Form"+reservation);
		Reservation reservation=(Reservation)hs.getAttribute("reservation");
		System.out.println("In ProcessSuccessfulProcess() POST   reservationid="+reservation.getReservationid());
		map.addAttribute("reservationid",reservation.getReservationid());
		return "SuccessfulProcess";		
		//return "redirect:/valid";

	}

	@RequestMapping(value = "/ViewReservationId")
	public String showViewReservationId(Reservation reservation,Model map,HttpSession hs,HttpServletRequest request) {
		System.out.println("in show SuccessfulProcess form " + reservation);

		System.out.println("scheduleid"+hs.getAttribute("reservation"));
		System.out.println("scheduleid"+hs.getAttribute("userid"));
		return "SuccessfulProcess";
	}

	@RequestMapping(value = "/ViewReservationId", method = RequestMethod.POST)
	public String processViewReservationId( Model map, HttpSession hs,HttpServletRequest request) {
		System.out.println("PROCESSViewReservationId() post");
		//System.out.println("Schedule ProcessReserveTicket Form"+reservation);
		Reservation reservation=(Reservation)hs.getAttribute("reservation");
		System.out.println("In processViewReservationId() POST   reservationid="+reservation.getReservationid());
		map.addAttribute("reservationid",reservation.getReservationid());
		return "SuccessfulProcess";		
		//return "redirect:/valid";

	}

	@RequestMapping(value = "/ViewTicket")
	public String showViewTicket(Reservation reservation,Model map,HttpSession hs,HttpServletRequest request) {
		System.out.println("in show SuccessfulProcess form " + reservation);

		System.out.println("scheduleid"+hs.getAttribute("reservation"));
		System.out.println("scheduleid"+hs.getAttribute("userid"));
		return "SuccessfulProcess";
	}

	@RequestMapping(value = "/ViewTicket", method = RequestMethod.POST)
	public String processViewTicket( Model map, HttpSession hs,HttpServletRequest request) {
		System.out.println("PROCESSViewReservationId() post");
		//System.out.println("Schedule ProcessReserveTicket Form"+reservation);
		Reservation reservation=(Reservation)hs.getAttribute("reservation");
		System.out.println("In processViewReservationId() POST   reservationid="+reservation.getReservationid());
		map.addAttribute("reservationid",reservation.getReservationid());
		return "SuccessfulProcess";		
		//return "redirect:/valid";

	}
	
	



}
