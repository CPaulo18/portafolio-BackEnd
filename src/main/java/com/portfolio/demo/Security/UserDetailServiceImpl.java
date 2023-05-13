package com.portfolio.demo.Security;

import com.portfolio.demo.Entity.Person;
import com.portfolio.demo.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
      Person person = personRepository
                  .findOneByEmail(email)
                  .orElseThrow(()-> new UsernameNotFoundException("the user with this email: "+ email +" not found"));

        return new UserDetailsImpl(person);
    }
}
