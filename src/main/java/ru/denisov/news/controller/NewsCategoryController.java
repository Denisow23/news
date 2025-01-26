package ru.denisov.news.controller;

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
import ru.denisov.news.dtos.NewsCategoryListResponseDTO;
import ru.denisov.news.dtos.NewsCategoryResponseDTO;
import ru.denisov.news.dtos.UpsertNewsCategoryDTO;
import ru.denisov.news.service.NewsCategoryService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/news/categories")
public class NewsCategoryController {

  private final NewsCategoryService newsCategoryService;

  @PostMapping
  public ResponseEntity<NewsCategoryResponseDTO> addNewsCategory(
      @RequestBody UpsertNewsCategoryDTO upsertNewsCategoryDTO) {
    return ResponseEntity.ok(newsCategoryService.add(upsertNewsCategoryDTO));
  }

  @GetMapping("/{id}")
  public ResponseEntity<NewsCategoryResponseDTO> getNewsCategory(@PathVariable Long id) {
    return ResponseEntity.ok(newsCategoryService.findById(id));
  }

  @GetMapping
  public ResponseEntity<NewsCategoryListResponseDTO> getNewsCategories() {
    return ResponseEntity.ok(newsCategoryService.findAll());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteNewsCategory(@PathVariable Long id) {
    newsCategoryService.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<NewsCategoryResponseDTO> updateNewsCategory(
      @PathVariable Long id,
      @RequestBody UpsertNewsCategoryDTO categoryDTO
  ) {
    return ResponseEntity.ok(newsCategoryService.updateById(id, categoryDTO));
  }
}
