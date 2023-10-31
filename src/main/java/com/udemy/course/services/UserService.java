package com.udemy.course.services;

import com.udemy.course.entities.User;
import com.udemy.course.repositories.UserRepository;
import com.udemy.course.services.exceptions.DatabaseException;
import com.udemy.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {
       return userRepository.save(obj);
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (DataIntegrityViolationException ex) {
            throw new DatabaseException(ex.getMessage());
        }
    }

    public User update(Long id, User obj) {
        User entity = userRepository.getReferenceById(id);
        updateData(entity, obj);
        return userRepository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }


}
