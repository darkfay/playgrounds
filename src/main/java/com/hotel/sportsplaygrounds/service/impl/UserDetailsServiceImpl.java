package com.hotel.sportsplaygrounds.service.impl;

import com.hotel.sportsplaygrounds.model.Role;
import com.hotel.sportsplaygrounds.model.User;
import com.hotel.sportsplaygrounds.repo.UsersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsersRepo usersRepo;
    private final PasswordEncoder encoder;


//    @PostConstruct
//    public void init() {
//        System.out.println(encoder.encode("admin"));
//        System.out.println(encoder.encode("user"));
//    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        Optional<User> userOp = usersRepo.findByEmail(username);
        return userOp.map(user -> new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                createAuthorities(user.getRoles())
        )).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    private List<? extends GrantedAuthority> createAuthorities(List<Role> roles) {
        return ofNullable(roles)
                .map(rolesList -> rolesList.stream().map(role -> new SimpleGrantedAuthority(role.getName()))
                        .collect(Collectors.toList())
                )
                .orElse(Collections.emptyList());
    }



}
