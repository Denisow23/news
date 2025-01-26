package ru.denisov.news.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpsertUserDTO {

  private String name;
  private String surname;
  private Integer age;
  private String login;
  private String password;

}
