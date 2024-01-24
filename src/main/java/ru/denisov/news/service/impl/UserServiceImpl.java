package ru.denisov.news.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.denisov.news.domain.user.User;
import ru.denisov.news.repository.CommentRepository;
import ru.denisov.news.repository.NewsRepository;
import ru.denisov.news.repository.UserRepository;
import ru.denisov.news.service.UserService;
import ru.denisov.news.service.exception.EntityNotFoundException;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        MessageFormat.format("User with id: {0} not found!", id
                    ))
                );
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        User changeableUser = userRepository.findById(user.getId()).orElseThrow(() -> new EntityNotFoundException(
                MessageFormat.format("User with id: {0} not found!", user.getId()
                ))
        );

        BeanUtils.copyProperties(user, changeableUser);

        return userRepository.save(changeableUser);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                MessageFormat.format("User with id: {0} not found!", id
                ))
        );
        userRepository.delete(user);
    }
}
