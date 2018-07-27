package beans.spot;

import java.util.Date;

public class Route {
	
	private Integer id_route;
	private String route_name;
	private String cotation;
	private Integer height;
	private Integer point_number;
	private String route_opener;
	private Date opening_year;
	
	
	public Integer getId_route() {
		return id_route;
	}
	public void setId_route(Integer id_route) {
		this.id_route = id_route;
	}
	public String getRoute_name() {
		return route_name;
	}
	public void setRoute_name(String route_name) {
		this.route_name = route_name;
	}
	public String getCotation() {
		return cotation;
	}
	public void setCotation(String cotation) {
		this.cotation = cotation;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getPoint_number() {
		return point_number;
	}
	public void setPoint_number(Integer point_number) {
		this.point_number = point_number;
	}
	public String getRoute_opener() {
		return route_opener;
	}
	public void setRoute_opener(String route_opener) {
		this.route_opener = route_opener;
	}
	public Date getOpening_year() {
		return opening_year;
	}
	public void setOpening_year(Date opening_year) {
		this.opening_year = opening_year;
	}
		
}
