package ru.denisov.news.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewsCategoryResponseDTO {

  private Long id;
  private String name;
  private Long newsCount;

}
