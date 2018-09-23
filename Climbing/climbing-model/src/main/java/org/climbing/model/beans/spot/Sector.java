package org.climbing.model.beans.spot;

import java.util.ArrayList;

public class Sector {
	
	private Integer id_sector;
	private String sector_name;
	private Integer nb_routes;
	private ArrayList<Route> routes;
	
	
	public Integer getId_sector() {
		return id_sector;
	}
	public void setId_sector(Integer id_sector) {
		this.id_sector = id_sector;
	}
	public String getSector_name() {
		return sector_name;
	}
	public void setSector_name(String sector_name) {
		this.sector_name = sector_name;
	}
	public Integer getNb_routes() {
		return nb_routes;
	}
	public void setNb_routes(Integer nb_routes) {
		this.nb_routes = nb_routes;
	}
	public ArrayList<Route> getRoutes() {
		return routes;
	}
	public void setRoutes(ArrayList<Route> routes) {
		this.routes = routes;
	}
}
