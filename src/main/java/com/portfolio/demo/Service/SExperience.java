package com.portfolio.demo.Service;

import com.portfolio.demo.Entity.Experience;
import com.portfolio.demo.Repository.RExperience;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SExperience {
    @Autowired
    RExperience rExperience;

    public List<Experience> list(){
        return rExperience.findAll();
    }

    public Optional<Experience> getOne(int id){
        return rExperience.findById(id);
    }

    public Optional<Experience> getByNameE(String expName){
        return rExperience.findByNameE(expName);
    }

    public void save(Experience exp){
        rExperience.save(exp);
    }

    public void Delete(int id){
        rExperience.deleteById(id);
    }
    public boolean existsById(int id){
        return rExperience.existsById(id);
    }
    public boolean existsByNameE(String expName){
        return rExperience.existsByNameE(expName);
    }
}
