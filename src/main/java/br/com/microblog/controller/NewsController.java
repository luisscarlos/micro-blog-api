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

import br.com.microblog.Model.NewsModel;
import br.com.microblog.entity.News;
import br.com.microblog.service.NewsService;

@RestController
@RequestMapping("/api/news")
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	@PostMapping
	public ResponseEntity<News> registerNews(@Valid @RequestBody NewsModel newsModel) {
		return new ResponseEntity<News>(newsService.registerNews(newsModel), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteNews(@PathVariable UUID id) {
		newsService.deleteNewsById(id);
	}
	
	@GetMapping
	public ResponseEntity<List<News>> findAllNews() {
		return new ResponseEntity<>(newsService.findAllNews(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<News> getNewsById(@PathVariable UUID id) {
		return new ResponseEntity<News>(newsService.findNewsById(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<News> updateNews(@PathVariable UUID id, @RequestBody News newstoUpdate) {
		return new ResponseEntity<>(newsService.updateNews(id, newstoUpdate), HttpStatus.OK);
	}
	
	@GetMapping("/filter/title/{title}")
	public ResponseEntity<List<News>> findNewsByTitle(@PathVariable String title) {	
		return new ResponseEntity<>(newsService.findNewsByTitle(title), HttpStatus.OK);
	}
	
	@GetMapping("/filter/tags/{tags}")
	public ResponseEntity<List<News>> findNewsByTags(@PathVariable String tags) {	
		return new ResponseEntity<>(newsService.findNewsByTags(tags), HttpStatus.OK);
	}

}
