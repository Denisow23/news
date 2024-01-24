package ru.denisov.news.service;

import ru.denisov.news.domain.comment.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getAllCommentsByNewsId(Long id);

    Long getCountCommentsByNewsId(Long id);

    Comment getComment(Long id);

    Comment createComment(Comment comment);

    Comment updateComment(Comment comment);

    void deleteComment(Long id);

    void deleteComments(List<Long> ids);


}
