package com.Pointage.adminPanel.service.impl;

import com.Pointage.adminPanel.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImp implements UserDetailsService {


    private final UserRepository repository ;

    public UserDetailsImp(UserRepository repository){
        this.repository = repository ;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username).orElseThrow(
                ()-> new UsernameNotFoundException("User not found !")
        );
    }
}
