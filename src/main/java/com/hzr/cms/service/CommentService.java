package com.hzr.cms.service;

import java.util.List;

import com.hzr.cms.domain.Comment;
/**
 * 评论业务层
 * @author Administrator
 *
 */
public interface CommentService {

	int addComment(Comment comment);

	List commentList(Integer id);

}
