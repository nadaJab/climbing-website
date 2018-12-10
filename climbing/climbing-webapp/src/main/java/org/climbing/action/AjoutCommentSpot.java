package org.climbing.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climbing.business.contract.ManagerFactory;
import org.climbing.model.beans.comment.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class AjoutCommentSpot extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LogManager.getLogger(AjoutCommentSpot.class);

	private CommentSpot commentSpotBean;
	private Comment commentBean;
	
	private Integer idSpot;

	@Autowired
	private ManagerFactory managerFactory;
	
	public String execute() {
		return SUCCESS;	
	}
	
	public CommentSpot getCommentSpotBean() {
		return commentSpotBean;
	}

	public void setCommentSpotBean(CommentSpot commentSpotBean) {
		this.commentSpotBean = commentSpotBean;
	}

	public Comment getCommentBean() {
		return commentBean;
	}

	public void setCommentBean(Comment commentBean) {
		this.commentBean = commentBean;
	}

	public Integer getIdSpot() {
		return idSpot;
	}

	public void setIdSpot(Integer idSpot) {
		this.idSpot = idSpot;
	}

	public String addCommentSpot() {
		String vResult = ActionSupport.INPUT;
		
		vResult = ActionSupport.SUCCESS;
		return vResult;
	}
			
}
