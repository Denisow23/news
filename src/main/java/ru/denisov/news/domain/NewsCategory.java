package ru.denisov.news.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;
import ru.denisov.news.domain.News;

@Entity(name = "news_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "category")
    private Set<News> news = new HashSet<>();
}
