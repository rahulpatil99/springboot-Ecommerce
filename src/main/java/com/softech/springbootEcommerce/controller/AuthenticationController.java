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
    @PostMapping("/token")
    public ResponseEntity<?> createJWTToken(@RequestBody AuthenticationRequestDTO authenticationRequestDTO) throws Exception{
        try{
            authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(authenticationRequestDTO.getUsername(),authenticationRequestDTO.getPassword()));
        }
        catch(Exception e){
            throw new Exception("Incorrect username and password");
        }
        MyUserDetailsService myUserDetailsService = new MyUserDetailsService();

        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequestDTO.getUsername());
        final String jwtToken = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponseDTO(jwtToken));
    }
}
