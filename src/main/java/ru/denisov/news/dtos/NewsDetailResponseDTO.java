package ru.denisov.news.dtos;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewsDetailResponseDTO {
  private Long newsId;
  private Long authorId;
  private String title;
  private String text;
  private String author;
  private List<String> newsCategory;
  private List<CommentResponseDTO> comments;
}
