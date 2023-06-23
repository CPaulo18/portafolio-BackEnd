package com.portfolio.demo.Service;

import com.portfolio.demo.Entity.Education;
import com.portfolio.demo.Repository.RepoEducation;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SEducation {
    @Autowired
    RepoEducation repoEducation;

    public List<Education> list(){
        return repoEducation.findAll();
    }
    public Optional<Education> getOne(int id){
        return repoEducation.findById(id);
    }

    public Optional<Education> getByNameE(String eduName){
        return repoEducation.findByNameE(eduName);
    }

    public void save(Education edu){
        repoEducation.save(edu);
    }

    public void Delete(int id){
        repoEducation.deleteById(id);
    }
    public boolean existsById(int id){
        return repoEducation.existsById(id);
    }
    public boolean existsByNameE(String eduName){
        return repoEducation.existsByNameE(eduName);
    }
}
