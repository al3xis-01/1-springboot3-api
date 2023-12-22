package com.yolanda.app.library.util;

import com.yolanda.app.library.security.*;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private JWTProvider jwtProvider;

    public AuthResponse login(AuthCredentials credentials){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword())
        );
        User user = userRepository.findByUsernameOrEmail(credentials.getUsername(), credentials.getUsername()).orElseThrow();
        String token = jwtProvider.generateToken(user.getUsername());

        return new AuthResponse(token, user);
    }

}
