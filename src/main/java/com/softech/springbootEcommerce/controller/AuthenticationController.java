package com.softech.springbootEcommerce.controller;

import com.softech.springbootEcommerce.dto.AuthenticationRequestDTO;
import com.softech.springbootEcommerce.dto.AuthenticationResponseDTO;
import com.softech.springbootEcommerce.service.MyUserDetailsService;
import com.softech.springbootEcommerce.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @PostMapping("/token")
    public ResponseEntity<?> createJWTToken(@RequestBody AuthenticationRequestDTO authenticationRequestDTO) {
        try {
            // Authenticate user
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequestDTO.getUsername(),
                            authenticationRequestDTO.getPassword()
                    )
            );

            // Load user details
            UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequestDTO.getUsername());

            // Generate JWT token
            String jwtToken = jwtTokenUtil.generateToken(userDetails);

            // Return token
            return ResponseEntity.ok(new AuthenticationResponseDTO(jwtToken));
        } catch (org.springframework.security.authentication.BadCredentialsException e) {
            // Handle invalid credentials
            return ResponseEntity.status(401).body("Invalid username or password");
        } catch (Exception e) {
            // Handle general exceptions
            return ResponseEntity.status(500).body("An error occurred while processing the request: " + e.getMessage());
        }
    }
}
