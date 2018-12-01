package org.climbing.model.beans.spot;

import java.util.ArrayList;

public class Sector {
	
	private Integer idSector;
	private String sectorName;
	private ArrayList<Route> routes;
	private Spot spotBean;
	
	
	public Integer getIdSector() {
		return idSector;
	}
	public void setIdSector(Integer idSector) {
		this.idSector = idSector;
	}
	public String getSectorName() {
		return sectorName;
	}
	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}
	public ArrayList<Route> getRoutes() {
		return routes;
	}
	public void setRoutes(ArrayList<Route> routes) {
		this.routes = routes;
	}
	public Spot getSpotBean() {
		return spotBean;
	}
	public void setSpotBean(Spot spotBean) {
		this.spotBean = spotBean;
	}
	
	
}
