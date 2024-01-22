package ru.denisov.news.domain.comment;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.denisov.news.domain.news.News;
import ru.denisov.news.domain.user.User;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String text;


    @ManyToOne
    @JoinColumn(name = "news_id")
    News news;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}
