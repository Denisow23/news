package ru.denisov.news.service;

import ru.denisov.news.dtos.CommentResponseDTO;
import ru.denisov.news.dtos.CommentsListResponseDTO;
import ru.denisov.news.dtos.UpsertCommentDTO;

public interface CommentService {

  CommentResponseDTO add(UpsertCommentDTO upsertCommentDTO, Long newsId);

  CommentResponseDTO updateById(UpsertCommentDTO upsertCommentDTO, Long commentId, Long newsId);

  void delete(Long id, Long newsId);

  CommentsListResponseDTO findByNews(Long newsId);

  CommentsListResponseDTO findByUser(Long userId);

}
