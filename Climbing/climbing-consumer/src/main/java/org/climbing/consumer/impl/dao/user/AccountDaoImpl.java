package org.climbing.consumer.impl.dao.user;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.contract.dao.user.AccountDao;

import org.climbing.model.beans.user.Account;
import org.climbing.model.exception.NotFoundException;
import org.springframework.stereotype.Component;

@Component("accountDao") 
public class AccountDaoImpl extends AbstractDaoImpl implements AccountDao  {
}
