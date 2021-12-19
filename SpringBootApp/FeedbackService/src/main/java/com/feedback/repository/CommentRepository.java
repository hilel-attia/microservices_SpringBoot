package com.feedback.repository;

import org.springframework.data.repository.CrudRepository;

import com.feedback.Entity.Comment;


public interface CommentRepository extends CrudRepository<Comment, Long> {

}
