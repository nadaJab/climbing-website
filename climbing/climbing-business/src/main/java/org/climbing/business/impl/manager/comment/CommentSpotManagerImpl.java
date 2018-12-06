package org.climbing.business.impl.manager.comment;

import org.climbing.business.contract.manager.comment.CommentSpotManager;
import org.climbing.business.impl.AbstractManagerImpl;

import org.climbing.model.beans.comment.CommentSpot;
import org.climbing.model.exception.NotFoundException;
import org.springframework.stereotype.Component;

@Component("commentSpotManager")
public class CommentSpotManagerImpl extends AbstractManagerImpl implements CommentSpotManager {

}
