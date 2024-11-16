package ru.denisov.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.denisov.news.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
