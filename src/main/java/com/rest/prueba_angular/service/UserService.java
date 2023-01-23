package com.rest.prueba_angular.service;

import com.rest.prueba_angular.model.User;
import com.rest.prueba_angular.repository.UserRepository;

import java.util.List;

public interface UserService {

    public User saveUser(User user);

    public void deleteUser(long id);

    public User findByIdUser(long id);

    public List<User> findAllUser();

}
