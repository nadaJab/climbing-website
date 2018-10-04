package org.climbing.action;
import com.opensymphony.xwork2.ActionSupport;

public class AjoutTopoAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nameTopo;
	private String author;
	private int nbCopyMax;
	private int editionYear;
	private String picture;
	
	public String execute() {
		return SUCCESS;	
	}
	
	public String getNameTopo() {
		return nameTopo;
	}
	public void setNameTopo(String nameTopo) {
		this.nameTopo = nameTopo;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getNbCopyMax() {
		return nbCopyMax;
	}
	public void setNbCopyMax(int nbCopyMax) {
		this.nbCopyMax = nbCopyMax;
	}
	public int getEditionYear() {
		return editionYear;
	}
	public void setEditionYear(int editionYear) {
		this.editionYear = editionYear;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	

}
