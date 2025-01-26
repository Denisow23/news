package ru.denisov.news.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDTO {

  private Long id;
  private String name;
  private String surname;
  private Integer age;
  private Long newsCount;
  private Long commentsCount;
}
