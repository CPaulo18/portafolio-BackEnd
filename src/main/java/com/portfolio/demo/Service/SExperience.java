package com.portfolio.demo.Service;

import com.portfolio.demo.Entity.Experience;
import com.portfolio.demo.Repository.RepoExperience;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SExperience {
    @Autowired
    RepoExperience repoExperience;

    public List<Experience> list(){
        return repoExperience.findAll();
    }

    public Optional<Experience> getOne(int id){
        return repoExperience.findById(id);
    }

    public Optional<Experience> getByNameE(String expName){
        return repoExperience.findByNameE(expName);
    }

    public void save(Experience exp){
        repoExperience.save(exp);
    }

    public void Delete(int id){
        repoExperience.deleteById(id);
    }
    public boolean existsById(int id){
        return repoExperience.existsById(id);
    }
    public boolean existsByNameE(String expName){
        return repoExperience.existsByNameE(expName);
    }
}
