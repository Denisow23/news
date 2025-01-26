package ru.denisov.news.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpsertCommentDTO {
  private String text;
  private Long authorId;
}
