package com.portfolio.demo.Controller;

import com.portfolio.demo.Dto.Mensaje;
import com.portfolio.demo.Dto.dtoEducation;

import com.portfolio.demo.Entity.Education;

import com.portfolio.demo.Service.SEducation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/education")
@CrossOrigin(origins = "http://localhost:4200")
public class CEducation {
    @Autowired
    SEducation sEducation;

    @GetMapping("/list")
    public ResponseEntity<List<Education>> list(){
        List<Education> list  = sEducation.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducation dtoEdu){
        if(StringUtils.isBlank(dtoEdu.getEduName()))
            return new ResponseEntity(new Mensaje("debe poner al menos un nombre"), HttpStatus.BAD_REQUEST);

        if(sEducation.existsByNameE(dtoEdu.getEduName())){
            new ResponseEntity(new Mensaje("the education name exsist"), HttpStatus.BAD_REQUEST);
        }

        Education edu = new Education(dtoEdu.getEduName(), dtoEdu.getEduDesc());
        sEducation.save(edu);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducation dtoEducation){
        if(!sEducation.existsById(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        if(sEducation.existsByNameE(dtoEducation.getEduName()) && sEducation.getByNameE(dtoEducation.getEduName()).get().getId() != id)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoEducation.getEduName()))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        Education education = sEducation.getOne(id).get();
        education.setEduName(dtoEducation.getEduName());
        education.setEduDesc(dtoEducation.getEduDesc());

        sEducation.save(education);
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sEducation.existsById(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        sEducation.Delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
