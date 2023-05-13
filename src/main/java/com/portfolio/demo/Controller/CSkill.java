package com.portfolio.demo.Controller;

import com.portfolio.demo.Dto.Mensaje;
import com.portfolio.demo.Entity.Skill;
import com.portfolio.demo.Dto.dtoSkill;
import com.portfolio.demo.Service.SSkill;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
@CrossOrigin("http://localhost:4200")
public class CSkill {
    @Autowired
    SSkill sSkill;
    @GetMapping("/list")
    public ResponseEntity<List<Skill>> list(){
        List<Skill> list = sSkill.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Skill> create(@RequestBody dtoSkill dtoS){
        if(StringUtils.isBlank(dtoS.getSkillName()))
        return new ResponseEntity(new Mensaje("complete the name"), HttpStatus.BAD_REQUEST);

        if(sSkill.existsByName(dtoS.getSkillName()))
        return new ResponseEntity(new Mensaje("the name exists"), HttpStatus.BAD_REQUEST);

        Skill s = new Skill(dtoS.getSkillName(), dtoS.getPorcent());
        sSkill.save(s);

        return new ResponseEntity(new Mensaje("skill added"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkill dtoS){
        if(!sSkill.existsById(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        if(sSkill.existsByName(dtoS.getSkillName()) && sSkill.getByName(dtoS.getSkillName()).get().getId() != id)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoS.getSkillName()))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        Skill s = sSkill.getOne(id).get();
        s.setSkillName(dtoS.getSkillName());
        s.setPorcent(dtoS.getPorcent());

        sSkill.save(s);
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sSkill.existsById(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        sSkill.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
