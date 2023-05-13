package com.portfolio.demo.Service;

import com.portfolio.demo.Entity.Education;
import com.portfolio.demo.Repository.REducation;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SEducation {
    @Autowired
    REducation rEducation;

    public List<Education> list(){
        return rEducation.findAll();
    }
    public Optional<Education> getOne(int id){
        return rEducation.findById(id);
    }

    public Optional<Education> getByNameE(String eduName){
        return rEducation.findByNameE(eduName);
    }

    public void save(Education edu){
        rEducation.save(edu);
    }

    public void Delete(int id){
        rEducation.deleteById(id);
    }
    public boolean existsById(int id){
        return rEducation.existsById(id);
    }
    public boolean existsByNameE(String eduName){
        return rEducation.existsByNameE(eduName);
    }
}
