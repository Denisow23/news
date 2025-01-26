package ru.denisov.news.service.impl;

import org.springframework.stereotype.Service;
import ru.denisov.news.dtos.NewsDetailResponseDTO;
import ru.denisov.news.dtos.NewsListResponseDTO;
import ru.denisov.news.dtos.UpsertNewsDTO;
import ru.denisov.news.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

  @Override
  public NewsDetailResponseDTO add(UpsertNewsDTO newsDTO) {
    return null;
  }

  @Override
  public NewsDetailResponseDTO getNewsDetails(Long id) {
    return null;
  }

  @Override
  public NewsListResponseDTO getNewsSummary() {
    return null;
  }

  @Override
  public NewsDetailResponseDTO updateNews(UpsertNewsDTO newsDTO, Long id) {
    return null;
  }

  @Override
  public void delete(Long id) {

  }
}
