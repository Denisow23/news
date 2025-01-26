package ru.denisov.news.service.impl;

import org.springframework.stereotype.Service;
import ru.denisov.news.dtos.NewsCategoryListResponseDTO;
import ru.denisov.news.dtos.NewsCategoryResponseDTO;
import ru.denisov.news.dtos.UpsertNewsCategoryDTO;
import ru.denisov.news.service.NewsCategoryService;

@Service
public class NewsCategoryImpl implements NewsCategoryService {

  @Override
  public NewsCategoryResponseDTO add(UpsertNewsCategoryDTO newsCategoryResponseDTO) {
    return null;
  }

  @Override
  public NewsCategoryResponseDTO findById(Long id) {
    return null;
  }

  @Override
  public NewsCategoryListResponseDTO findAll() {
    return null;
  }

  @Override
  public void deleteById(Long id) {

  }

  @Override
  public NewsCategoryResponseDTO updateById(Long id, UpsertNewsCategoryDTO categoryDTO) {
    return null;
  }
}
