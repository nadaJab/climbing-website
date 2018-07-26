package org.climbing.consumer.impl;

import org.climbing.consumer.contract.dao.comment.CommentDao;
import org.climbing.consumer.contract.dao.comment.CommentSpotDao;
import org.climbing.consumer.contract.dao.comment.CommentTopoDao;
import org.climbing.consumer.contract.dao.spot.CountryDao;
import org.climbing.consumer.contract.dao.spot.RouteDao;
import org.climbing.consumer.contract.dao.spot.SectorDao;
import org.climbing.consumer.contract.dao.spot.SpotDao;
import org.climbing.consumer.contract.dao.topo.BookingTopoDao;
import org.climbing.consumer.contract.dao.topo.TopoDao;
import org.climbing.consumer.contract.dao.user.AccountDao;
import org.climbing.consumer.contract.dao.user.UserDao;

public class DaoFactoryImpl {

	//***************
		//****comment****
		//***************
		private CommentDao commentDao;
		private CommentSpotDao commentSpotDao;
		private CommentTopoDao commentTopoDao;

		//************	
		//****spot****
		//************
		private CountryDao countryDao;
		private RouteDao routeDao;
		private SectorDao sectorDao;
		private SpotDao spotDao;
		
		//***************
		//****topo****
		//***************
		private BookingTopoDao bookingTopoDao;
		private TopoDao topoDao;
		
		//***************
		//****user****
		//***************	
		private AccountDao accountDao;
		private UserDao userDao;
		
		//*******
		public CommentDao getCommentDao() {
			return commentDao;
		}
		public void setCommentDao(CommentDao commentDao) {
			this.commentDao = commentDao;
		}
		public CommentSpotDao getCommentSpotDao() {
			return commentSpotDao;
		}
		public void setCommentSpotDao(CommentSpotDao commentSpotDao) {
			this.commentSpotDao = commentSpotDao;
		}
		public CommentTopoDao getCommentTopoDao() {
			return commentTopoDao;
		}
		public void setCommentTopoDao(CommentTopoDao commentTopoDao) {
			this.commentTopoDao = commentTopoDao;
		}
		
		//**********
		public CountryDao getCountryDao() {
			return countryDao;
		}
		public void setCountryDao(CountryDao countryDao) {
			this.countryDao = countryDao;
		}
		public RouteDao getRouteDao() {
			return routeDao;
		}
		public void setRouteDao(RouteDao routeDao) {
			this.routeDao = routeDao;
		}
		public SectorDao getSectorDao() {
			return sectorDao;
		}
		public void setSectorDao(SectorDao sectorDao) {
			this.sectorDao = sectorDao;
		}
		public SpotDao getSpotDao() {
			return spotDao;
		}
		public void setSpotDao(SpotDao spotDao) {
			this.spotDao = spotDao;
		}
		
		//*********
		public BookingTopoDao getBookingTopoDao() {
			return bookingTopoDao;
		}
		public void setBookingTopoDao(BookingTopoDao bookingTopoDao) {
			this.bookingTopoDao = bookingTopoDao;
		}
		public TopoDao getTopoDao() {
			return topoDao;
		}
		public void setTopoDao(TopoDao topoDao) {
			this.topoDao = topoDao;
		}
		
		//******
		public AccountDao getAccountDao() {
			return accountDao;
		}
		public void setAccountDao(AccountDao accountDao) {
			this.accountDao = accountDao;
		}
		public UserDao getUserDao() {
			return userDao;
		}
		public void setUserDao(UserDao userDao) {
			this.userDao = userDao;
		}
		
}
