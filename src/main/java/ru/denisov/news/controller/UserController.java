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
import ru.denisov.news.dtos.CommentsListResponseDTO;
import ru.denisov.news.dtos.UpsertUserDTO;
import ru.denisov.news.dtos.UserResponseDTO;
import ru.denisov.news.service.CommentService;
import ru.denisov.news.service.UserService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/users")
public class UserController {

  private final UserService userService;
  private final CommentService commentService;

  @PostMapping()
  public ResponseEntity<UserResponseDTO> addUser(@RequestBody UpsertUserDTO userDTO) {
    return ResponseEntity.ok(userService.add(userDTO));
  }

  @GetMapping
  public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
    return ResponseEntity.ok(userService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserResponseDTO> getUser(@PathVariable Long id) {
    return ResponseEntity.ok(userService.findById(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    userService.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserResponseDTO> updateUser(
      @PathVariable Long id, @RequestBody UserResponseDTO updateUser) {
    return ResponseEntity.ok(userService.update(id, updateUser));
  }

  @GetMapping("/{userId}/comments")
  public ResponseEntity<CommentsListResponseDTO> getCommentsByUser(@PathVariable Long userId) {
    return ResponseEntity.ok(commentService.findByUser(userId));
  }

}
