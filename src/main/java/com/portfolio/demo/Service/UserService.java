package com.portfolio.demo.Service;

import com.portfolio.demo.Entity.Education;
import com.portfolio.demo.Entity.User;
import com.portfolio.demo.Repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService  {
    @Autowired IUserRepository iUserRepository;

    public List<User> list(){
        return iUserRepository.findAll();
    }

    public Optional<User> getOne(int id){
        return iUserRepository.findById(id);
    }

    public Optional<User> getByNameU(String firstName){
        return iUserRepository.findByNameU(firstName);
    }

    public void save(User user){ iUserRepository.save(user);
    }

    public void Delete(int id){
        iUserRepository.deleteById(id);
    }
    public boolean existsById(int id){
        return iUserRepository.existsById(id);
    }
    public boolean existsByNameU(String expName){
        return iUserRepository.existsByNameU(expName);
    }
}
