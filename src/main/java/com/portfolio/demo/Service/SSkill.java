package com.portfolio.demo.Service;

import com.portfolio.demo.Entity.Skill;
import com.portfolio.demo.Repository.RepoSkill;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class SSkill {
    @Autowired
    RepoSkill repoSkill;

    public List<Skill> list(){
        return repoSkill.findAll();
    }

    public Optional<Skill> getOne(int id){
        return repoSkill.findById(id);
    }

    public Optional<Skill> getByName(String skillName){
        return repoSkill.findByNameS(skillName);
    }

    public void save(Skill s){
         repoSkill.save(s);
    }

    public void delete(int id){
        repoSkill.deleteById(id);
    }

    public boolean existsByName(String skillName){
        return repoSkill.existsByNameS(skillName);
    }

    public boolean existsById(int id){
        return repoSkill.existsById(id);
    }
}
