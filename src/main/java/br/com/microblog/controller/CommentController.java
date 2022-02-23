package br.com.microblog.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.microblog.Model.CommentModel;
import br.com.microblog.entity.Comment;
import br.com.microblog.service.CommentService;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/{newsId}")
	public ResponseEntity<Comment> registerComment(@Valid @PathVariable UUID newsId, @RequestBody CommentModel commentModel) {
		return new ResponseEntity<Comment>(commentService.registerComment(newsId, commentModel), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteComment(@PathVariable UUID id) {
		commentService.deleteCommentById(id);
	}
	
	@GetMapping
	public ResponseEntity<List<Comment>> findAllComments() {
		return new ResponseEntity<>(commentService.findAllComments(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Comment> getCommentById(@PathVariable UUID id) {
		return new ResponseEntity<Comment>(commentService.findCommentById(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Comment> updateComment(@PathVariable UUID id, @RequestBody Comment commenttoUpdate) {
		return new ResponseEntity<>(commentService.updateComment(id, commenttoUpdate), HttpStatus.OK);
	}

}
