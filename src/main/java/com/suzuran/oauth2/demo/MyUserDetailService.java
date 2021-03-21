package com.suzuran.oauth2.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Qualifier("MyUserDetailService")
public class MyUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public MyUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> byUsername = userRepository.findByUsername(username);
        if (byUsername.isEmpty()) throw new UsernameNotFoundException("User not found");
        UserHelper userHelper = new UserHelper(byUsername.get());
        userHelper.setUsername(byUsername.get().getUsername());
        userHelper.setId(byUsername.get().getId());
        userHelper.setEmail(byUsername.get().getEmail());
        return userHelper;
    }
}
