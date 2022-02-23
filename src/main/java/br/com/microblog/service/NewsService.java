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

import br.com.microblog.Model.NewsModel;
import br.com.microblog.entity.News;
import br.com.microblog.repository.NewsRepository;
import lombok.NoArgsConstructor;

@Service
@Transactional
@NoArgsConstructor
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public News registerNews(@Valid NewsModel newsModel) {
        News news = new News();
        news.setTitle(newsModel.getTitle());
        news.setAuthor(newsModel.getAuthor());
        news.setContent(newsModel.getContent());
        news.setTags(newsModel.getTags());
        
        return newsRepository.save(news);
     }
    
    public void deleteNewsById(UUID id) {
    	News newsFind = newsRepository.findById(id)
    			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "News not found: ID " + id));
    	
    	newsRepository.deleteById(newsFind.getId());
    }
    
    public List<News> findAllNews() {
    	return newsRepository.findAll();
    }
    
    public News findNewsById(UUID id) {
    	return newsRepository.findById(id)
    			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "News not found: ID " + id));
    }
    
    public News updateNews(UUID id, News newsToUpdate) {
    	News newsFind = newsRepository.findById(id)
    			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "News not found: ID " + id));
    	
    	newsToUpdate.setId(id);
    	newsToUpdate.setDate(new Timestamp(System.currentTimeMillis()));
    	newsToUpdate.setComment(newsFind.getComment());
    	return newsRepository.save(newsToUpdate);
    }
    
    public List<News> findNewsByTitle(String title) {
    	return newsRepository.findByTitleContaining(title);
    }
    
    public List<News> findNewsByTags(String tags) {
    	return newsRepository.findByTagsContaining(tags);
    }
}
