package org.climbing.consumer.impl.dao.comment;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.contract.dao.comment.CommentSpotDao;

import org.climbing.model.beans.comment.CommentSpot;
import org.climbing.model.exception.NotFoundException;
import org.springframework.stereotype.Component;

@Component("commentSpotDao") 
public class CommentSpotDaoImpl extends AbstractDaoImpl implements 	CommentSpotDao {

}
