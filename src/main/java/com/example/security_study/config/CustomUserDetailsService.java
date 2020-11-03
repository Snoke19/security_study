package com.example.security_study.config;

import com.example.security_study.model.User;
import com.example.security_study.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  public CustomUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    Optional<User> user = userRepository.findByUserName(s);

    user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + s));

    return user.map(CustomUserDetails::new).get();
  }
}
