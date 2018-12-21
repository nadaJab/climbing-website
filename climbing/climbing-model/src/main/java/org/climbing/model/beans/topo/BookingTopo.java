package org.climbing.model.beans.topo;

import java.util.Date;
import javax.inject.Named;


@Named("bookingBean")
public class BookingTopo {
	
	private Integer idBookingTopo;
	private Date borrowingDate;
	private Date returnDate;
	private Integer idUser;
	private Integer idTopo;
	
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
	@Override
	public String toString() {
		return "BookingTopo [idBookingTopo=" + idBookingTopo + ", borrowingDate=" + borrowingDate + ", returnDate="
				+ returnDate + ", idUser=" + idUser + ", idTopo=" + idTopo + "]";
	}
	
}
