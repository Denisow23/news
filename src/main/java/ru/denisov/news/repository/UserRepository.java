package ru.denisov.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.denisov.news.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
