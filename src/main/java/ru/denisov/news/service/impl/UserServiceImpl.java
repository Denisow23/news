package ru.denisov.news.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.denisov.news.dtos.UpsertUserDTO;
import ru.denisov.news.dtos.UserResponseDTO;
import ru.denisov.news.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Override
  public UserResponseDTO add(UpsertUserDTO userDTO) {
    return null;
  }

  @Override
  public UserResponseDTO findById(Long id) {
    return null;
  }

  @Override
  public void deleteById(Long id) {

  }

  @Override
  public List<UserResponseDTO> findAll() {
    return null;
  }

  @Override
  public UserResponseDTO update(Long id, UserResponseDTO updateUser) {
    return null;
  }
}
