package org.climbing.consumer.impl.dao.user;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.contract.dao.user.UserDao;

import org.climbing.model.beans.user.User;
import org.climbing.model.exception.NotFoundException;
import org.springframework.stereotype.Component;

@Component("userDao") 
public class UserDaoImpl extends AbstractDaoImpl implements UserDao  {
}
