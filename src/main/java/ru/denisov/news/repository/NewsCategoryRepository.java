package ru.denisov.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.denisov.news.domain.NewsCategory;

@Repository
public interface NewsCategoryRepository extends JpaRepository<NewsCategory, Long> {

}
