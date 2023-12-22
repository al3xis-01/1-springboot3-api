package com.yolanda.app.library.controller.api;


import com.yolanda.app.library.security.AuthCredentials;
import com.yolanda.app.library.security.AuthResponse;
import com.yolanda.app.library.util.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Authentication")
@AllArgsConstructor
public class AuthenticationController {

    private AuthenticationService authenticationService;

    @PostMapping("/Login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthCredentials credentials){
        AuthResponse response = authenticationService
                .login(credentials);
        return ResponseEntity.ok(response);
    }

}
