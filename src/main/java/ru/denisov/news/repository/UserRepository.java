package ru.denisov.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.denisov.news.domain.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
