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
import ru.denisov.news.dtos.NewsCategoryDTO;
import ru.denisov.news.service.NewsCategoryService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/v1/api/news/categories")
public class NewsCategoryController {

  private final NewsCategoryService newsCategoryService;

  @PostMapping
  public ResponseEntity<NewsCategoryDTO> addNewsCategory(@RequestBody NewsCategoryDTO newsCategoryDTO)  {
    return ResponseEntity.ok(newsCategoryService.add(newsCategoryDTO));
  }

  @GetMapping("/{id}")
  public ResponseEntity<NewsCategoryDTO> getNewsCategory(@PathVariable Long id) {
    return ResponseEntity.ok(newsCategoryService.findById(id));
  }

  @GetMapping
  public ResponseEntity<List<NewsCategoryDTO>> getNewsCategories() {
    return ResponseEntity.ok(newsCategoryService.findAll());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteNewsCategory(@PathVariable Long id) {
    newsCategoryService.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/id")
  public ResponseEntity<NewsCategoryDTO> updateNewsCategory(@PathVariable Long id,
      @RequestBody NewsCategoryDTO categoryDTO) {
    return ResponseEntity.ok(newsCategoryService.updateById(id, categoryDTO));
  }
}
