package com.feedback.service;

import java.util.List;

import com.feedback.Entity.Comment;


public interface ICommentService {
	
	public Comment add(Comment Comment);
	public List<Comment> getAll();
	public Comment update(Comment Comment,Long idComment);
	public boolean delete(Long idComment);
	public Comment findOneById(Long idComment);

}
