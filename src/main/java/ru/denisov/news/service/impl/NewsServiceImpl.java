package ru.denisov.news.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.denisov.news.domain.news.News;
import ru.denisov.news.repository.NewsRepository;
import ru.denisov.news.service.NewsService;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;
    @Override
    public List<News> getAllNews() {
        return null;
    }

    @Override
    public List<News> getAllNewsByCategoryId() {
        return null;
    }

    @Override
    public News createNews(News news) {
        return null;
    }

    @Override
    public News updateNews(News news) {
        return null;
    }

    @Override
    public void deleteNewsById(Long id) {

    }

    @Override
    public void deleteNewsInCategory(Long categoryId) {

    }
}
