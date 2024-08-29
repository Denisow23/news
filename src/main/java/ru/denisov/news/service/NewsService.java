package ru.denisov.news.service;

import ru.denisov.news.domain.news.News;

import java.util.List;

public interface NewsService {

    List<News> getAllNews();

    List<News> getAllNewsByCategoryId(Long categoryId, Integer page, Integer countOnPage);

    News createNews(News news);

    News updateNews(News news);

    void deleteNewsById(Long id);

    void deleteNewsInCategory(Long categoryId);

}
