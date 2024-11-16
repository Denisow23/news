package ru.denisov.news.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.denisov.news.dtos.NewsDTO;
import ru.denisov.news.dtos.NewsDetailDTO;
import ru.denisov.news.dtos.NewsSummaryDTO;

@Service
public interface NewsService {

  NewsDTO add(NewsDTO newsDTO);

  NewsDetailDTO getNewsDetails(Long id);

  List<NewsSummaryDTO> getNewsSummary();

  NewsDetailDTO updateNews(NewsDTO newsDTO);

  void delete(Long id);
}
