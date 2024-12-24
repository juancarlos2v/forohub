package com.alura.forohub.controllers;

import com.alura.forohub.dto.RequestLogin;
import com.alura.forohub.dto.ResponseDTO;
import com.alura.forohub.entities.User;
import com.alura.forohub.services.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody RequestLogin request) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
        var userAuth=authenticationManager.authenticate(authToken);

        var jwtToken= jwtService.generateToken((User) userAuth.getPrincipal());

        return ResponseEntity.ok(new ResponseDTO(jwtToken) );
    }
}
