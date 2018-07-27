package beans.spot;

import java.util.ArrayList;

public class Spot {
	
	private Integer id_spot;
	private String spot_name;
	private Integer total_routes_nb;
	private String cotation_max;
	private String cotation_min;
	private String orientation;
	private String climbing_type;
	private String rock_type;
	private Country country;
	private ArrayList<Sector> sectors;
	
	
	public Integer getId_spot() {
		return id_spot;
	}
	public void setId_spot(Integer id_spot) {
		this.id_spot = id_spot;
	}
	public String getSpot_name() {
		return spot_name;
	}
	public void setSpot_name(String spot_name) {
		this.spot_name = spot_name;
	}
	public Integer getTotal_routes_nb() {
		return total_routes_nb;
	}
	public void setTotal_routes_nb(Integer total_routes_nb) {
		this.total_routes_nb = total_routes_nb;
	}
	public String getCotation_max() {
		return cotation_max;
	}
	public void setCotation_max(String cotation_max) {
		this.cotation_max = cotation_max;
	}
	public String getCotation_min() {
		return cotation_min;
	}
	public void setCotation_min(String cotation_min) {
		this.cotation_min = cotation_min;
	}
	public String getOrientation() {
		return orientation;
	}
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	public String getClimbing_type() {
		return climbing_type;
	}
	public void setClimbing_type(String climbing_type) {
		this.climbing_type = climbing_type;
	}
	public String getRock_type() {
		return rock_type;
	}
	public void setRock_type(String rock_type) {
		this.rock_type = rock_type;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public ArrayList<Sector> getSectors() {
		return sectors;
	}
	public void setSectors(ArrayList<Sector> sectors) {
		this.sectors = sectors;
	}
	
}
