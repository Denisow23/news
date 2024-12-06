package ru.denisov.news.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.denisov.news.dtos.CommentDTO;

@Service
public interface CommentService {

  CommentDTO add(CommentDTO commentDTO);

  CommentDTO updateById(CommentDTO commentDTO, Long id);

  void delete(Long id);

  List<CommentDTO> findByNews(Long newsId);

  List<CommentDTO> findByUser(Long userId);

}
