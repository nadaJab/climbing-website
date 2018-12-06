package org.climbing.model.beans.comment;

import javax.inject.Named;

@Named("commentSpotBean")
public class CommentSpot extends Comment{

	private int idSpotBean;
	
	public CommentSpot() {
		super();
	}

	public int getIdSpotBean() {
		return idSpotBean;
	}

	public void setIdSpotBean(int idSpotBean) {
		this.idSpotBean = idSpotBean;
	}
	
}
