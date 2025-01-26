package ru.denisov.news.service;

import java.util.List;
import ru.denisov.news.dtos.UpsertUserDTO;
import ru.denisov.news.dtos.UserResponseDTO;

public interface UserService {

  UserResponseDTO add(UpsertUserDTO userDTO);

  UserResponseDTO findById(Long id);

  void deleteById(Long id);

  List<UserResponseDTO> findAll();

  UserResponseDTO update(Long id, UserResponseDTO updateUser);
}
