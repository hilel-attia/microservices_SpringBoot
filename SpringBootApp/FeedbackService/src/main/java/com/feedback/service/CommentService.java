package com.feedback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.Entity.Comment;
import com.feedback.repository.CommentRepository;

@Service
public class CommentService implements ICommentService {
	
	@Autowired
	CommentRepository commentRepository;

	@Override
	public Comment add(Comment Comment) {
		return commentRepository.save(Comment) ;
	}

	@Override
	public List<Comment> getAll() {
		return (List<Comment>) commentRepository.findAll();
	}

	@Override
	public Comment update(Comment Comment, Long idComment) {
		Comment com=commentRepository.findById(idComment).orElse(null);
		if(com!=null)
		{
			com.setDescription(Comment.getDescription());
			//com.setDate(livraison.getDate());
			commentRepository.save(com);
			return com;
		}
		
		return null;
	}

	@Override
	public boolean delete(Long idComment) {
		Comment prod=commentRepository.findById(idComment).get();
		if(prod!=null)
		{
			commentRepository.deleteById(idComment);
			return true;
		}
		return false;
	}

	@Override
	public Comment findOneById(Long idComment) {
		return commentRepository.findById(idComment).orElse(null);
	}

}
