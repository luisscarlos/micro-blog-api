package br.com.microblog.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.microblog.entity.News;

public interface NewsRepository extends JpaRepository<News, UUID> {
	
	public List<News> findByTitleContaining(String title);
	
	public List<News> findByTagsContaining(String tags);
}
