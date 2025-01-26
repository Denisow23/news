package ru.denisov.news.dtos;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewResponsesDTO {
  private Long newsId;
  private String title;
  private String text;
  private Long authorId;
  private Long countOfComments;
  private List<String> newsCategory;
}
