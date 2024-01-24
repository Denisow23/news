package ru.denisov.news.repository;

import org.hibernate.validator.internal.engine.resolver.JPATraversableResolver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.denisov.news.domain.news.News;
import ru.denisov.news.domain.news.NewsCategory;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long>, JpaSpecificationExecutor<News> {

    List<News> findAllByCategory_Id(Long categoryId);
}
