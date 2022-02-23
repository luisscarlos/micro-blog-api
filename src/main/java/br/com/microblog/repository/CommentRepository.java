package br.com.microblog.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.microblog.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
}
