package ru.denisov.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.denisov.news.domain.comment.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
