package org.climbing.model.beans.topo;

import java.util.Date;
import javax.inject.Named;

import org.climbing.model.beans.user.User;


@Named("bookingBean")
public class BookingTopo {
	
	private Integer idBookingTopo;
	private Date borrowingDate;
	private Date returnDate;
	private Integer idUser;
	private Integer idTopo;
	private boolean returnConfirmation; 
	private User userBean;
	private Topo topoBean;
	
	public Integer getIdBookingTopo() {
		return idBookingTopo;
	}
	public void setIdBookingTopo(Integer idBookingTopo) {
		this.idBookingTopo = idBookingTopo;
	}
	public Date getBorrowingDate() {
		return borrowingDate;
	}
	public void setBorrowingDate(Date borrowingDate) {
		this.borrowingDate = borrowingDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public Integer getIdTopo() {
		return idTopo;
	}
	public void setIdTopo(Integer idTopo) {
		this.idTopo = idTopo;
	}
	public boolean isReturnConfirmation() {
		return returnConfirmation;
	}
	public void setReturnConfirmation(boolean returnConfirmation) {
		this.returnConfirmation = returnConfirmation;
	}
	
	public User getUserBean() {
		return userBean;
	}
	public void setUserBean(User userBean) {
		this.userBean = userBean;
	}
	public Topo getTopoBean() {
		return topoBean;
	}
	public void setTopoBean(Topo topoBean) {
		this.topoBean = topoBean;
	}
	@Override
	public String toString() {
		return "BookingTopo [idBookingTopo=" + idBookingTopo + ", borrowingDate=" + borrowingDate + ", returnDate="
				+ returnDate + ", idUser=" + idUser + ", idTopo=" + idTopo + ", returnConfirmation="
				+ returnConfirmation + ", userBean=" + userBean + ", topoBean=" + topoBean + "]";
	}
	
}
