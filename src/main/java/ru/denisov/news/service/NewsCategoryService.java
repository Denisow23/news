package ru.denisov.news.service;

import ru.denisov.news.dtos.NewsCategoryListResponseDTO;
import ru.denisov.news.dtos.NewsCategoryResponseDTO;
import ru.denisov.news.dtos.UpsertNewsCategoryDTO;

public interface NewsCategoryService {

  NewsCategoryResponseDTO add(UpsertNewsCategoryDTO newsCategoryResponseDTO);

  NewsCategoryResponseDTO findById(Long id);

  NewsCategoryListResponseDTO findAll();

  void deleteById(Long id);

  NewsCategoryResponseDTO updateById(Long id, UpsertNewsCategoryDTO categoryDTO);
}
