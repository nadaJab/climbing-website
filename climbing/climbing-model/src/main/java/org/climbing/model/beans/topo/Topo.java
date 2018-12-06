package org.climbing.model.beans.topo;

import java.util.Date;

import javax.inject.Named;

@Named("topoBean")
public class Topo {
	
	private Integer idTopo;
	private String topoName;
	private String author;
	private Integer nbCopyMax;
	private Date editionYear;
	private Date published;
	private String imageURL;
	
	public Integer getIdTopo() {
		return idTopo;
	}
	public void setIdTopo(Integer idTopo) {
		this.idTopo = idTopo;
	}
	public String getTopoName() {
		return topoName;
	}
	public void setTopoName(String topoName) {
		this.topoName = topoName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getNbCopyMax() {
		return nbCopyMax;
	}
	public void setNbCopyMax(Integer nbCopyMax) {
		this.nbCopyMax = nbCopyMax;
	}
	public Date getEditionYear() {
		return editionYear;
	}
	public void setEditionYear(Date editionYear) {
		this.editionYear = editionYear;
	}
	public Date getPublished() {
		return published;
	}
	public void setPublished(Date published) {
		this.published = published;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
}
