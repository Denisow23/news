package ru.denisov.news.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpsertNewsCategoryDTO {

  private String categoryName;

}
