package ru.denisov.news.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.denisov.news.dtos.CommentResponseDTO;
import ru.denisov.news.dtos.CommentsListResponseDTO;
import ru.denisov.news.dtos.NewsDetailResponseDTO;
import ru.denisov.news.dtos.NewsListResponseDTO;
import ru.denisov.news.dtos.UpsertCommentDTO;
import ru.denisov.news.dtos.UpsertNewsDTO;
import ru.denisov.news.service.CommentService;
import ru.denisov.news.service.NewsService;

@RestController
@RequestMapping("/api/v1/news")
@RequiredArgsConstructor
public class NewsController {

  private final NewsService newsService;
  private final CommentService commentService;

  @PostMapping()
  public ResponseEntity<NewsDetailResponseDTO> addNews(@RequestBody UpsertNewsDTO newsDTO) {
    return ResponseEntity.ok(newsService.add(newsDTO));
  }

  @GetMapping("/{id}")
  public ResponseEntity<NewsDetailResponseDTO> getNews(@PathVariable Long id) {
    return ResponseEntity.ok(newsService.getNewsDetails(id));
  }

  @GetMapping()
  public ResponseEntity<NewsListResponseDTO> getNewsSummary() {
    return ResponseEntity.ok(newsService.getNewsSummary());
  }

  @PutMapping("/{id}")
  public ResponseEntity<NewsDetailResponseDTO> updateNews(
      @PathVariable Long id,
      @RequestBody UpsertNewsDTO newsDTO
  ) {
    return ResponseEntity.ok(newsService.updateNews(newsDTO, id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteNews(@PathVariable Long id) {
    newsService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/{newsId}/comments")
  public ResponseEntity<CommentsListResponseDTO> getCommentsByNews(@PathVariable Long newsId) {
    return ResponseEntity.ok(commentService.findByNews(newsId));
  }

  @PostMapping("/{newsId}/comments")
  public ResponseEntity<CommentResponseDTO> addComment(
      @RequestBody UpsertCommentDTO upsertCommentDTO,
      @PathVariable Long newsId) {
    return ResponseEntity.ok(commentService.add(upsertCommentDTO, newsId));
  }

  @PutMapping("/{newsId}/comments/{commentId}")
  public ResponseEntity<CommentResponseDTO> editComment(
      @PathVariable Long newsId,
      @PathVariable Long commentId,
      @RequestBody UpsertCommentDTO upsertCommentDTO
  ) {
    return ResponseEntity.ok(commentService.updateById(upsertCommentDTO, commentId, newsId));
  }

  @PostMapping("/{newsId}/comments/{commentId}")
  public ResponseEntity<Void> deleteComment(
      @PathVariable Long newsId,
      @PathVariable Long commentId
  ) {
    commentService.delete(commentId, newsId);
    return ResponseEntity.noContent().build();
  }
}
