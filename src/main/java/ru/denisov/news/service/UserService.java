package ru.denisov.news.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.denisov.news.dtos.UserDTO;

@Service
public interface UserService {

  UserDTO add(UserDTO userDTO);
  UserDTO findById(Long id);
  void deleteById(Long id);
  List<UserDTO> findAll();
  UserDTO update(Long id, UserDTO updateUser);
}
