package ru.denisov.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.denisov.news.domain.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
