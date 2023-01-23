package com.rest.prueba_angular.service;

import com.rest.prueba_angular.model.User;
import com.rest.prueba_angular.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
        log.info("se borro con exito usuario con id " + id);
    }

    @Override
    public User findByIdUser(long id) {

        Optional<User> optional = userRepository.findById(id);

        User user = null;
        if (((Optional<?>) optional).isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException(" Usuario no se encontro por id : " + id);
        }

        log.info("Se busco Usuario con exito " + id);
        return user;
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }
}
