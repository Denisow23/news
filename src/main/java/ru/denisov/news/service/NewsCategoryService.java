package ru.denisov.news.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.denisov.news.dtos.NewsCategoryDTO;

@Service
public interface NewsCategoryService {

  NewsCategoryDTO add(NewsCategoryDTO newsCategoryDTO);
  NewsCategoryDTO findById(Long id);
  List<NewsCategoryDTO> findAll();
  void deleteById(Long id);
  NewsCategoryDTO updateById(Long id, NewsCategoryDTO categoryDTO);
}
