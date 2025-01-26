package ru.denisov.news.dtos;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpsertNewsDTO {

  private Long authorId;
  private String title;
  private String text;
  private List<Long> newsCategoryIds;

}
