package org.climbing.model.beans.comment;

import java.util.Date;

import javax.inject.Named;

import org.climbing.model.beans.user.User;

@Named("commentBean")
public class Comment {

	// ==================== Attributs ====================
	private Integer idComment;
	private String content;
	private Date dateComment;
	private Integer idUser;
	private User user;
	// ==================== Getters/Setters ====================
	
	public String getContent() {
		return content;
	}
	public Integer getIdComment() {
		return idComment;
	}
	public void setIdComment(Integer idComment) {
		this.idComment = idComment;
	}
	public Date getDateComment() {
		return dateComment;
	}
	public void setDateComment(Date dateComment) {
		this.dateComment = dateComment;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Comment [idComment=" + idComment + ", content=" + content + ", dateComment=" + dateComment + ", idUser="
				+ idUser + ", user=" + user + "]";
	}
	
}
