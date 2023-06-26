package com.portfolio.demo.Controller;

import com.portfolio.demo.Dto.Mensaje;
import com.portfolio.demo.Dto.dtoUser;
import com.portfolio.demo.Entity.User;
import com.portfolio.demo.Service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = {"https://frontendap-65c03.web.app","http://localhost:4200"})
public class UserController {
    @Autowired
    UserService sUser;

    @GetMapping("/list")
    public ResponseEntity<List<User>> list(){
        List<User> list  = sUser.list();
        return  new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<User> getById(@PathVariable("id")int id){
        if(!sUser.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        User user = sUser.getOne(id).get();
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoUser dtoUser){
        if(StringUtils.isBlank(dtoUser.getFirstName()))
            return new ResponseEntity(new Mensaje("debe poner al menos un nombre"), HttpStatus.BAD_REQUEST);

        if(sUser.existsByNameU(dtoUser.getFirstName())){
            new ResponseEntity(new Mensaje("the education name exsist"), HttpStatus.BAD_REQUEST);
        }

        User user = new User(dtoUser.getFirstName(), dtoUser.getLastName(), dtoUser.getDescription(), dtoUser.getImg());
        sUser.save(user);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoUser dtoUser){
        if(!sUser.existsById(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        if(sUser.existsByNameU(dtoUser.getFirstName()) && sUser.getByNameU(dtoUser.getFirstName()).get().getId() != id)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoUser.getFirstName()))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        User user = sUser.getOne(id).get();
        user.setFirstName(dtoUser.getFirstName());
        user.setLastName(dtoUser.getLastName());
        user.setDescription(dtoUser.getDescription());
        user.setImg(dtoUser.getImg());

        sUser.save(user);
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sUser.existsById(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        sUser.Delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
 }
