package br.com.microblog.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.microblog.Model.CommentModel;
import br.com.microblog.entity.Comment;
import br.com.microblog.entity.News;
import br.com.microblog.repository.CommentRepository;
import br.com.microblog.repository.NewsRepository;
import lombok.NoArgsConstructor;

@Service
@Transactional
@NoArgsConstructor
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    
    @Autowired
    private NewsRepository newsRepository;

    public Comment registerComment(@Valid UUID newsId, CommentModel commentModel) {
    	News newsFind = newsRepository.findById(newsId)
    			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "News not found: ID " + newsId));
    	
    	Comment comment = new Comment();
    	comment.setNews(newsFind);
    	comment.setContent(commentModel.getContent());
    	comment.setAuthor(commentModel.getAuthor());
        
        return commentRepository.save(comment);
     }
    
    public void deleteCommentById(UUID id) {
    	Comment commentFind = commentRepository.findById(id)
    			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found: ID " + id));
    	
    	commentRepository.deleteById(commentFind.getId());
    }
    
    public List<Comment> findAllComments() {
    	return commentRepository.findAll();
    }
    
    public Comment findCommentById(UUID id) {
    	return commentRepository.findById(id)
    			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found: ID " + id));
    }
    
    public Comment updateComment(UUID id, Comment commentToUpdate) {
    	commentRepository.findById(id)
    			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found: ID " + id));
    	
    	commentToUpdate.setId(id);
    	commentToUpdate.setDate(new Timestamp(System.currentTimeMillis()));
    	return commentRepository.save(commentToUpdate);
    }
}
