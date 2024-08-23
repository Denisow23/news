package ru.denisov.news.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.control.MappingControl.Use;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.denisov.news.dtos.RequestStatusDTO;
import ru.denisov.news.dtos.UserDTO;
import ru.denisov.news.service.UserService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/v1/api/user")
public class UserController {

  private final UserService userService;

  @PostMapping()
  public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
    return ResponseEntity.ok(userService.addUser(userDTO));
  }

  @GetMapping
  public ResponseEntity<List<UserDTO>> getAllUsers() {
    return ResponseEntity.ok(userService.findAll());
  }
  @GetMapping("/{id}")
  public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
    return ResponseEntity.ok(userService.findById(id));
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<RequestStatusDTO> deleteUser(@PathVariable Long id) {
    return ResponseEntity.ok(userService.delete(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserDTO> updateUser(@PathVariable Long id) {
    return ResponseEntity.ok(userService.updateUser(id));
  }


}
