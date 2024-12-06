package ru.denisov.news.controller;


import java.util.List;
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
import ru.denisov.news.dtos.NewsDTO;
import ru.denisov.news.dtos.NewsDetailDTO;
import ru.denisov.news.dtos.NewsSummaryDTO;
import ru.denisov.news.service.NewsService;

@RestController
@RequestMapping("/api/v1/news")
@RequiredArgsConstructor
public class NewsController {

  private final NewsService newsService;

  @PostMapping()
  public ResponseEntity<NewsDTO> addNews(@RequestBody NewsDTO newsDTO) {
    return ResponseEntity.ok(newsService.add(newsDTO));
  }

  @GetMapping("/{id}")
  public ResponseEntity<NewsDetailDTO> getNews(@PathVariable Long id) {
    return ResponseEntity.ok(newsService.getNewsDetails(id));
  }

  @GetMapping()
  public ResponseEntity<List<NewsSummaryDTO>> getNewsSummary() {
    return ResponseEntity.ok(newsService.getNewsSummary());
  }

  @PutMapping("/{id}")
  public ResponseEntity<NewsDetailDTO> updateNews(
      @PathVariable Long id,
      @RequestBody NewsDTO newsDTO
  ) {
    return ResponseEntity.ok(newsService.updateNews(newsDTO, id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteNews(@PathVariable Long id) {
    newsService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
