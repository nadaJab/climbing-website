package org.climbing.model.beans.comment;

import org.climbing.model.beans.spot.Spot;

public class CommentSpot extends Comment{

	private Spot spot;
	
	public CommentSpot() {
		super();
	}
	
	public Spot getSpot() {
		return spot;
	}

	public void setSpot(Spot spot) {
		this.spot = spot;
	}
}
