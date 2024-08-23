package ru.denisov.news.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.denisov.news.dtos.NewsCategoryDTO;
import ru.denisov.news.service.NewsCategoryService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/v1/api/news/category")
public class NewsCategoryController {

  private final NewsCategoryService newsCategoryService;

  @PostMapping
  public ResponseEntity<NewsCategoryDTO> addNewsCategory(@RequestBody NewsCategoryDTO newsCategoryDTO)  {
    return ResponseEntity.ok(newsCategoryService.add(newsCategoryDTO));
  }

  public ResponseEntity<List<NewsCategoryDTO>>
}
