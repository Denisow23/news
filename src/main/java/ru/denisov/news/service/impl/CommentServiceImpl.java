package ru.denisov.news.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.denisov.news.domain.comment.Comment;
import ru.denisov.news.repository.CommentRepository;
import ru.denisov.news.service.CommentService;
import ru.denisov.news.service.exception.EntityNotFoundException;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public List<Comment> getAllCommentsByNewsId(Long newsId) {
        return commentRepository.findAllByNewsId(newsId);
    }

    @Override
    public Long getCountCommentsByNewsId(Long newsId) {
        return commentRepository.countAllByNewsId(newsId);
    }

    @Override
    @Transactional
    public Comment getComment(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        MessageFormat.format("Entity with id: {0} not found!", id)
                ));

    }

    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public Comment updateComment(Comment comment) {
        Comment changeableComment = commentRepository.findById(comment.getId())
                .orElseThrow(() -> new EntityNotFoundException(
                        MessageFormat.format("Comment with id: {0} not found!", comment.getId())
                ));

        BeanUtils.copyProperties(comment, changeableComment);

        return commentRepository.save(changeableComment);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        MessageFormat.format("Entity with id: {0} not found!", id)
                ));

        commentRepository.deleteById(id);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public void deleteComments(List<Long> ids) {
        List<Long> existedIds = ids.stream()
                .filter(commentRepository::existsById)
                .toList();

        commentRepository.deleteAllById(existedIds);
    }
}
