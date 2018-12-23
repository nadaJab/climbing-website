package org.climbing.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.climbing.business.contract.ManagerFactory;
import org.climbing.model.beans.comment.*;
import org.climbing.model.beans.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class GestionComment extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LogManager.getLogger(GestionComment.class);

	private Comment commentBean;
	private Integer idSpot;
	private Integer idTopo;
	private Integer idComment;
	private ArrayList<Comment> comment;
	private Map<String, Object> session;
	private static final String USER = "user";

	@Autowired
	private ManagerFactory managerFactory;
	
	/*
	public String execute() {
		return SUCCESS;	
	} */
	
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
	
	public Integer getIdTopo() {
		return idTopo;
	}

	public void setIdTopo(Integer idTopo) {
		this.idTopo = idTopo;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;	
	}
	
	public ArrayList<Comment> getComment() {
		return comment;
	}

	public void setComment(ArrayList<Comment> comment) {
		this.comment = comment;
	}

	public Integer getIdComment() {
		return idComment;
	}

	public void setIdComment(Integer idComment) {
		this.idComment = idComment;
	}

	public String addCommentSpot() {
		String vResult = ActionSupport.INPUT;
		
		LOGGER.debug(((User) session.get(USER)).getIdUser());
		
		commentBean.setIdUser(((User) session.get(USER)).getIdUser());
		
		commentBean.setDateComment(Calendar.getInstance().getTime());
		LOGGER.debug(commentBean.getDateComment() + "date du commentaire");

		commentBean = managerFactory.getCommentManager().addComment(commentBean);
		LOGGER.debug(commentBean.toString() + "détails commentaire " + idSpot);

		managerFactory.getCommentSpotManager().addJoinCommentSpot(commentBean.getIdComment(), idSpot);
		
		vResult = ActionSupport.SUCCESS;
		return vResult;
	}
	
	public String addCommentTopo() {
		String vResult = ActionSupport.INPUT;
		
		commentBean.setIdUser(((User) session.get(USER)).getIdUser());
		commentBean.setDateComment(Calendar.getInstance().getTime());

		commentBean = managerFactory.getCommentManager().addComment(commentBean);
		managerFactory.getCommentTopoManager().addJoinCommentTopo(commentBean.getIdComment(), idTopo);
		
		vResult = ActionSupport.SUCCESS;
		return vResult;
	}
	
	public String deleteCommentSpot() {
		String vResult = ActionSupport.INPUT;
		
		managerFactory.getCommentManager().deleteCommentSpot(idComment);
		
		vResult = ActionSupport.SUCCESS;
		return vResult;
	}
	
	public String deleteCommentTopo() {
		String vResult = ActionSupport.INPUT;
		
		managerFactory.getCommentManager().deleteCommentSpot(idComment);
		
		vResult = ActionSupport.SUCCESS;
		return vResult;
	}
			
}
