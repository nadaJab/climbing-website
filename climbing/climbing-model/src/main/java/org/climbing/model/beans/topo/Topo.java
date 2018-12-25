package org.climbing.model.beans.topo;

import java.util.Date;

import javax.inject.Named;

@Named("topoBean")
public class Topo {
	
	private Integer idTopo;
	private String topoName;
	private String author;
	private Integer nbCopyMax;
	private Integer editionYear;
	private Date published;

	
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
	
	public Integer getEditionYear() {
		return editionYear;
	}
	public void setEditionYear(Integer editionYear) {
		this.editionYear = editionYear;
	}
	public Date getPublished() {
		return published;
	}
	public void setPublished(Date published) {
		this.published = published;
	}
	
	@Override
	public String toString() {
		return "Topo [idTopo=" + idTopo + ", topoName=" + topoName + ", author=" + author + ", nbCopyMax=" + nbCopyMax
				+ ", editionYear=" + editionYear + ", published=" + published + "]";
	}
	
}
