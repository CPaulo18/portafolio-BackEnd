package com.portfolio.demo.Controller;

import com.portfolio.demo.Dto.Mensaje;
import com.portfolio.demo.Dto.dtoExperience;
import com.portfolio.demo.Entity.Experience;
import com.portfolio.demo.Entity.Skill;
import com.portfolio.demo.Service.SExperience;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experience")
public class CExperience {
    @Autowired
    SExperience sExperience;
    @GetMapping("/list")
    public ResponseEntity<List<Experience>> list(){
        List<Experience> list = sExperience.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experience> getById(@PathVariable("id")int id){
        if(!sExperience.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Experience experience = sExperience.getOne(id).get();
        return new ResponseEntity(experience, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperience dtoexp) {
        if(StringUtils.isBlank(dtoexp.getExpName()))
            return new ResponseEntity(new Mensaje("debe poner al menos un nombre"), HttpStatus.BAD_REQUEST);

        if(sExperience.existsByNameE(dtoexp.getExpName()))
            return new ResponseEntity(new Mensaje("el nombre ya existe"), HttpStatus.BAD_REQUEST);

        Experience experience = new Experience(dtoexp.getExpName(), dtoexp.getExpDesc());
                sExperience.save(experience);

                return new ResponseEntity(HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperience dtoexp){
        if(!sExperience.existsById(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        if(sExperience.existsByNameE(dtoexp.getExpName()) && sExperience.getByNameE(dtoexp.getExpName()).get().getId() != id)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoexp.getExpName()))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        Experience experience = sExperience.getOne(id).get();
        experience.setExpName(dtoexp.getExpName());
        experience.setExpDesc(dtoexp.getExpDesc());

        sExperience.save(experience);
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
     public  ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sExperience.existsById(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        sExperience.Delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
