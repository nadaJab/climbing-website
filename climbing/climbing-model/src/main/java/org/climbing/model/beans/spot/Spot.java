package org.climbing.model.beans.spot;

import java.util.ArrayList;

public class Spot {
	
	private Integer idSpot;
	private String spotName;
	private Integer nbRoutesTotal;
	private String cotationMax;
	private String cotationMin;
	private String orientation;
	private String climbingType;
	private Country country;
	private ArrayList<Sector> sectors;
	
	
	public Integer getIdSpot() {
		return idSpot;
	}
	public void setIdSpot(Integer idSpot) {
		this.idSpot = idSpot;
	}
	public String getSpotName() {
		return spotName;
	}
	public void setSpotName(String spotName) {
		this.spotName = spotName;
	}
	
	public Integer getNbRoutesTotal() {
		return nbRoutesTotal;
	}
	public void setNbRoutesTotal(Integer nbRoutesTotal) {
		this.nbRoutesTotal = nbRoutesTotal;
	}
	public String getCotationMax() {
		return cotationMax;
	}
	public void setCotationMax(String cotationMax) {
		this.cotationMax = cotationMax;
	}
	public String getCotationMin() {
		return cotationMin;
	}
	public void setCotationMin(String cotationMin) {
		this.cotationMin = cotationMin;
	}
	public String getOrientation() {
		return orientation;
	}
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	public String getClimbingType() {
		return climbingType;
	}
	public void setClimbingType(String climbingType) {
		this.climbingType = climbingType;
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
	@Override
	public String toString() {
		return "Spot [idSpot=" + idSpot + ", spotName=" + spotName + ", nbRoutesTotal=" + nbRoutesTotal
				+ ", cotationMax=" + cotationMax + ", cotationMin=" + cotationMin + ", orientation=" + orientation
				+ ", climbingType=" + climbingType + ", country=" + country + ", sectors=" + sectors + "]";
	}	
	
	
}
