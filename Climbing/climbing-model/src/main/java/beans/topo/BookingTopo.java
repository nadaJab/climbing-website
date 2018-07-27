package beans.topo;

import java.util.Date;

import beans.user.User;

public class BookingTopo {
	
	private Integer id_bookingTopo;
	private Date borrowing_date;
	private Date return_date;
	private User user;
	private Topo topo;
	
	
	public Integer getId_bookingTopo() {
		return id_bookingTopo;
	}
	public void setId_bookingTopo(Integer id_bookingTopo) {
		this.id_bookingTopo = id_bookingTopo;
	}
	public Date getBorrowing_date() {
		return borrowing_date;
	}
	public void setBorrowing_date(Date borrowing_date) {
		this.borrowing_date = borrowing_date;
	}
	public Date getReturn_date() {
		return return_date;
	}
	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Topo getTopo() {
		return topo;
	}
	public void setTopo(Topo topo) {
		this.topo = topo;
	}

}
