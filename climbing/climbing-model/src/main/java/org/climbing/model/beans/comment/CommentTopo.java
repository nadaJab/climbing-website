package org.climbing.model.beans.comment;

import org.climbing.model.beans.topo.Topo;

public class CommentTopo extends Comment{
	
	private Topo topo;
	
	public CommentTopo() {
		super();
	}
	
	public Topo getTopo() {
		return topo;
	}

	public void setTopo(Topo topo) {
		this.topo = topo;
	}
}
