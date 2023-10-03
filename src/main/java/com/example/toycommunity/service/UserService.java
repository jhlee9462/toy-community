package com.example.toycommunity.service;

import com.example.toycommunity.dto.request.UserSignUpRequestDto;
import com.example.toycommunity.entity.UserDetailsImpl;
import com.example.toycommunity.repository.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDetailsImpl> optionalUserDetails = userDetailsRepository.findById(username);
        return optionalUserDetails.orElse(null);
    }

    public boolean signUp(UserSignUpRequestDto userSignUpRequestDto) {
        userDetailsRepository.save(UserDetailsImpl.of(userSignUpRequestDto));

        return true;
    }
}
