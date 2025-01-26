package ru.denisov.news.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "news")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String text;
  @ManyToMany
  @JoinTable(
      name = "news_2_category",
      joinColumns = @JoinColumn(name = "news_id"),
      inverseJoinColumns = @JoinColumn(name = "category_id")
  )
  private Set<NewsCategory> category = new HashSet<>();
  @ManyToOne
  @JoinColumn(name = "author_id")
  @ToString.Exclude
  private User author;
  @OneToMany(mappedBy = "news", cascade = CascadeType.ALL)
  @ToString.Exclude
  private List<Comment> comments = new ArrayList<>();
}
