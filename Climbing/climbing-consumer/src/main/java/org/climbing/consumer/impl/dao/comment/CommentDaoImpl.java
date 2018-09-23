package org.climbing.consumer.impl.dao.comment;

import org.climbing.consumer.impl.AbstractDaoImpl;
import org.climbing.consumer.contract.dao.comment.CommentDao;

import org.climbing.model.beans.comment.Comment;
import org.climbing.model.exception.NotFoundException;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Senkez nada
 * Classe d'implémentation de {@link CommentDao}.
 */

@Component("commentDao") 
public class CommentDaoImpl extends AbstractDaoImpl implements CommentDao  {

}
