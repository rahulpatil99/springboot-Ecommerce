package com.softech.springbootEcommerce.filter;

import com.softech.springbootEcommerce.util.JwtTokenUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");
        String username = null;
        String token = null;

        try {
            // Extract the JWT token from the Authorization header
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                token = authorizationHeader.substring(7); // Remove "Bearer " prefix
                username = jwtTokenUtil.extractUsername(token); // Extract username
            }

            // Validate token and set authentication in context if valid
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                if (jwtTokenUtil.validateToken(token, userDetails)) {
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                } else {
                    logger.info("Invalid JWT token for username: " + username);
                }
            }

        } catch (io.jsonwebtoken.MalformedJwtException e) {
            logger.error("Malformed JWT token: " + e.getMessage());
        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            logger.warn("Expired JWT token: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Error processing JWT token: " + e.getMessage());
        }

        // Continue the filter chain
        filterChain.doFilter(request, response);
    }
}
