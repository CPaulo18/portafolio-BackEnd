package com.portfolio.demo.Service;

import com.portfolio.demo.Entity.Skill;
import com.portfolio.demo.Repository.RSkill;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class SSkill {
    @Autowired
    RSkill rSkill;

    public List<Skill> list(){
        return rSkill.findAll();
    }

    public Optional<Skill> getOne(int id){
        return rSkill.findById(id);
    }

    public Optional<Skill> getByName(String skillName){
        return rSkill.findByNameS(skillName);
    }

    public void save(Skill s){
         rSkill.save(s);
    }

    public void delete(int id){
        rSkill.deleteById(id);
    }

    public boolean existsByName(String skillName){
        return rSkill.existsByNameS(skillName);
    }

    public boolean existsById(int id){
        return rSkill.existsById(id);
    }
}
