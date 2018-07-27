package beans.comment;

import java.util.Date;
import beans.user.User;

public class Comment {

	// ==================== Attributs ====================
	private Integer id_comment;
	private String content;
	private Date date_comment;
	private User user;
	
	// ==================== Getters/Setters ====================
	public Integer getId_comment() {
		return id_comment;
	}
	public void setId_comment(Integer id_comment) {
		this.id_comment = id_comment;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate_comment() {
		return date_comment;
	}
	public void setDate_comment(Date date_comment) {
		this.date_comment = date_comment;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
