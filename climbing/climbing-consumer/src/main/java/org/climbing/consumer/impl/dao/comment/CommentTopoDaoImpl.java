package org.climbing.consumer.impl.dao.comment;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.contract.dao.comment.CommentTopoDao;

import org.climbing.model.beans.comment.CommentTopo;
import org.climbing.model.exception.NotFoundException;
import org.springframework.stereotype.Component;

@Component("commentTopoDao") 
public class CommentTopoDaoImpl extends AbstractDaoImpl implements CommentTopoDao  {
}
