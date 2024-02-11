package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService  {

    private final UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

 @Override
    public void addUser(User user) {
        userRepo.save(user);
    }

 @Override
    @Transactional(readOnly = true)
    public User findUserById(Long id) {
        return userRepo.getById(id);
    }

 @Override
    @Transactional(readOnly = true)
    public User findUserByLogin(String login) {
        return userRepo.findByLogin(login);
    }

 @Override
    public void editUserById(User user) {
        userRepo.save(user);
    }

 @Override
    public void removeUserById(Long id) {
        userRepo.deleteById(id);
    }

 @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

}
