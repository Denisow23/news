package ru.denisov.news.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import ru.denisov.news.domain.news.News;
import ru.denisov.news.repository.NewsRepository;
import ru.denisov.news.service.NewsService;
import ru.denisov.news.service.exception.EntityNotFoundException;

import java.awt.*;
import java.text.MessageFormat;
import java.util.List;
import java.util.Random;

@Repository
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;
    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public List<News> getAllNewsByCategoryId(Long categoryId, Integer page, Integer countOnPage) {
        return newsRepository.findAllByCategory_Id(categoryId, PageRequest.of(page, countOnPage)).getContent();
    }

    @Override
    public News createNews(News news) {
        return newsRepository.save(news);
    }

    @Override
    public News updateNews(News news) {
        News changableNews = newsRepository.findById(news.getId())
                .orElseThrow(() -> new EntityNotFoundException(
                        MessageFormat.format("News with ID: {0} not found!", news.getId())
                ));

        BeanUtils.copyProperties(news, changableNews);

        return newsRepository.save(changableNews);
    }

    @Override
    public void deleteNewsById(Long id) {
        News news = newsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        MessageFormat.format("News with ID: {0} not found!", id)
                ));
    }

    @Override
    public void deleteNewsInCategory(Long categoryId) {
        List<Long> ids = newsRepository.findAllByCategory_Id(categoryId)
                .stream()
                .map(News::getId)
                .filter(newsRepository::existsById)
                .toList();
        Long random = new Random().nextLong(10000L, 20000L);

        newsRepository.deleteAllById(ids);
    }
}
