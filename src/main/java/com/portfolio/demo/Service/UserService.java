package com.portfolio.demo.Service;

import com.portfolio.demo.Entity.User;
import com.portfolio.demo.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService  {
    @Autowired
    UserRepository userRepository;

    public List<User> list(){
        return userRepository.findAll();
    }

    public Optional<User> getOne(int id){
        return userRepository.findById(id);
    }

    public Optional<User> getByNameU(String firstName){
        return userRepository.findByNameU(firstName);
    }

    public void save(User user){ userRepository.save(user);
    }

    public void Delete(int id){
        userRepository.deleteById(id);
    }
    public boolean existsById(int id){
        return userRepository.existsById(id);
    }
    public boolean existsByNameU(String expName){
        return userRepository.existsByNameU(expName);
    }
}
