package ru.denisov.news.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.denisov.news.dtos.CommentDTO;
import ru.denisov.news.service.CommentService;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

  private final CommentService commentService;

  @GetMapping
  public ResponseEntity<List<CommentDTO>> getCommentsByNews(@RequestParam("news") Long newsId) {
    return ResponseEntity.ok(commentService.findByNews(newsId));
  }

  @GetMapping
  public ResponseEntity<List<CommentDTO>> getCommentsByUser(@RequestParam("user") Long userId) {
    return ResponseEntity.ok(commentService.findByUser(userId));
  }

  @PostMapping()
  public ResponseEntity<CommentDTO> addComment(@RequestBody CommentDTO commentDTO) {
    return ResponseEntity.ok(commentService.add(commentDTO));
  }

  @PutMapping("/{id}")
  public ResponseEntity<CommentDTO> editComment(
      @PathVariable Long id,
      @RequestBody CommentDTO commentDTO
  ) {
    return ResponseEntity.ok(commentService.updateById(commentDTO, id));
  }

  @PostMapping("/{id}")
  public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
    commentService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
