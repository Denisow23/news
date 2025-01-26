package ru.denisov.news.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentResponseDTO {

  private Long commentId;
  private String text;
  private Long authorId;
  private String authorName;
  private String newsId;

}
