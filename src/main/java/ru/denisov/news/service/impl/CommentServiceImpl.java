package ru.denisov.news.service.impl;

import org.springframework.stereotype.Service;
import ru.denisov.news.dtos.CommentResponseDTO;
import ru.denisov.news.dtos.CommentsListResponseDTO;
import ru.denisov.news.dtos.UpsertCommentDTO;
import ru.denisov.news.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

  @Override
  public CommentResponseDTO add(UpsertCommentDTO upsertCommentDTO, Long newsId) {
    return null;
  }

  @Override
  public CommentResponseDTO updateById(UpsertCommentDTO upsertCommentDTO, Long commentId, Long newsId) {
    return null;
  }

  @Override
  public void delete(Long id, Long newsId) {

  }

  @Override
  public CommentsListResponseDTO findByNews(Long newsId) {
    return null;
  }

  @Override
  public CommentsListResponseDTO findByUser(Long userId) {
    return null;
  }
}
