package ru.denisov.news.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.denisov.news.dtos.UserDTO;
import ru.denisov.news.service.UserService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/v1/api/users")
public class UserController {

  private final UserService userService;

  @PostMapping()
  public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
    return ResponseEntity.ok(userService.add(userDTO));
  }

  @GetMapping
  public ResponseEntity<List<UserDTO>> getAllUsers() {
    return ResponseEntity.ok(userService.findAll());
  }
  @GetMapping("/{id}")
  public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
    return ResponseEntity.ok(userService.findById(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    userService.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO updateUser) {
    return ResponseEntity.ok(userService.update(id, updateUser));
  }


}
