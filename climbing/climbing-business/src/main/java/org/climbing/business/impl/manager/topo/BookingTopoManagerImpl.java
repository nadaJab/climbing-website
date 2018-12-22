package org.climbing.business.impl.manager.topo;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;

import org.climbing.business.contract.manager.topo.BookingTopoManager;
import org.climbing.business.impl.AbstractManagerImpl;

import org.climbing.model.beans.topo.BookingTopo;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component("bookingTopoManager")
public class BookingTopoManagerImpl extends AbstractManagerImpl implements BookingTopoManager {

	@Inject
	@Named("PlatformTransactionManager")
	private PlatformTransactionManager platformTransactionManager;

	ArrayList<BookingTopo> listBooking;

	@Override
	public ArrayList<BookingTopo> getBookingTopoInfo(int idTopo) {
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 

		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);

		try {
			listBooking = getDaoFactory().getBookingTopoDao().getBookingTopoInfoDao(idTopo);

			TransactionStatus vTScommit = vTransactionStatus;
			vTransactionStatus = null;
			platformTransactionManager.commit(vTScommit);	
		} finally {
			if (vTransactionStatus != null) {
				platformTransactionManager.rollback(vTransactionStatus);
			}
		}
		return listBooking;
	}

	@Override
	public void addBookingTopo(BookingTopo bookingTopo) {
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 

		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);

		try {

			getDaoFactory().getBookingTopoDao().addBookingTopoDao(bookingTopo);;

			TransactionStatus vTScommit = vTransactionStatus;
			vTransactionStatus = null;
			platformTransactionManager.commit(vTScommit);	
		} finally {
			if (vTransactionStatus != null) {
				platformTransactionManager.rollback(vTransactionStatus);
			}
		}

	}

	@Override
	public boolean updateTopoReturn(int idTopo) {
		boolean result=false;
		
		DefaultTransactionDefinition vDefintion = new DefaultTransactionDefinition();
		vDefintion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		vDefintion.setTimeout(30); 

		TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(vDefintion);

		try {

			getDaoFactory().getBookingTopoDao().updateTopoReturnDao(idTopo);
			 result=true;
			 
			TransactionStatus vTScommit = vTransactionStatus;
			vTransactionStatus = null;
			platformTransactionManager.commit(vTScommit);	
		} finally {
			if (vTransactionStatus != null) {
				platformTransactionManager.rollback(vTransactionStatus);
			}
		}
		return result;
	}
}
