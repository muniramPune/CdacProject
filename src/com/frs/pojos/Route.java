package com.frs.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the FRS_TBL_ROUTE database table.
 * 
 */
@Entity
@Table(name="FRS_TBL_ROUTE")
@NamedQuery(name="Route.findAll", query="SELECT r FROM Route r")
public class Route  {
	private static final long serialVersionUID = 1L;
	private long routeid;
	private String destination;
	private double distance;
	private double fare;
	private String source;



	public Route() {
	}


	@Id
	@SequenceGenerator(name="FRS_TBL_ROUTE_ROUTEID_GENERATOR", sequenceName="FRS_SEQ_ROUTE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FRS_TBL_ROUTE_ROUTEID_GENERATOR")
	public long getRouteid() {
		return this.routeid;
	}

	public void setRouteid(long routeid) {
		this.routeid = routeid;
	}


	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}


	public double getDistance() {
		return this.distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}


	public double getFare() {
		return this.fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}


	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "Route [routeid=" + routeid + ", destination=" + destination
				+ ", distance=" + distance + ", fare=" + fare + ", source="
				+ source + "]";
	}

}