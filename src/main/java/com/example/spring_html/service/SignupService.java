package com.example.spring_html.service;

import com.example.spring_html.entity.Member;
import com.example.spring_html.model.SignUpRequest;
import com.example.spring_html.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 6410450087 Kittikan Makphon
 */

@Service
public class SignupService {
    @Autowired
    private MemberRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    public boolean isUsernameAvailable(String username) {
        return repository.findByUsername(username) == null;
    }


    public void createUser(SignUpRequest user) {
        Member record = modelMapper.map(user, Member.class);
        record.setRole("USER");

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        record.setPassword(hashedPassword);


        repository.save(record);
    }


    public Member getUser(String username) {
        return repository.findByUsername(username);
    }

}