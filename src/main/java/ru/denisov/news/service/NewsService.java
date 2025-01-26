package ru.denisov.news.service;

import ru.denisov.news.dtos.NewsDetailResponseDTO;
import ru.denisov.news.dtos.NewsListResponseDTO;
import ru.denisov.news.dtos.UpsertNewsDTO;

public interface NewsService {

  NewsDetailResponseDTO add(UpsertNewsDTO newsDTO);

  NewsDetailResponseDTO getNewsDetails(Long id);

  NewsListResponseDTO getNewsSummary();

  NewsDetailResponseDTO updateNews(UpsertNewsDTO newsDTO, Long id);

  void delete(Long id);
}
