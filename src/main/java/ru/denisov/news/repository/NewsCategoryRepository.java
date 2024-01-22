package ru.denisov.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.denisov.news.domain.news.NewsCategory;

public interface NewsCategoryRepository extends JpaRepository<NewsCategory, Long> {
}
