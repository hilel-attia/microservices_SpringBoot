package com.feedback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.feedback.Entity.Comment;
import com.feedback.service.CommentService;

@RestController
@RequestMapping("/apicomment")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@GetMapping("/comments")
	public ResponseEntity<List<Comment>> getAllComment() {
		try {
			List<Comment> CommentList = commentService.getAll();

			if (CommentList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(CommentList, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/comment/{id}")
	public ResponseEntity<Comment> getCommentById(@PathVariable("id") long id) {
		return ((commentService.findOneById(id) != null)
				? new ResponseEntity<>(commentService.findOneById(id), HttpStatus.CREATED)
				: new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR));

	}

	@PostMapping("/comment")
	public ResponseEntity<Comment> createComment(@RequestBody Comment Comment) {
		return ((commentService.add(Comment) != null)
				? new ResponseEntity<>(commentService.add(Comment), HttpStatus.CREATED)
				: new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR));

	}

	@PutMapping("/comment/{id}")
	public ResponseEntity<Comment> updateComment(@PathVariable("id") long id, @RequestBody Comment Comment) {
		return ((commentService.update(Comment, id) != null)
				? new ResponseEntity<>(commentService.update(Comment, id), HttpStatus.CREATED)
				: new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR));
	}
	
	
	@DeleteMapping("/comment/{id}")
	public ResponseEntity<Comment> deleteComment(@PathVariable("id") long id) {
		return ((commentService.delete(id))
				? new ResponseEntity<>(null, HttpStatus.CREATED)
				: new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR));
	}

}
