package com.hzr.cms.dao;

import java.util.List;

import com.hzr.cms.domain.Comment;
/**
 * 评论dao层接口
 * @author Administrator
 *
 */
public interface CommentDAO {

	int addComment(Comment comment);

	List commentList(Integer id);

}
