package com.chandu.e_commerce.configuration;

import com.chandu.e_commerce.service.serviceimpl.JWTService;
import com.chandu.e_commerce.service.serviceimpl.MyUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

public class JWTFilter extends OncePerRequestFilter
{
    private final HandlerExceptionResolver handlerExceptionResolver;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private ApplicationContext context;

    @Autowired
    public JWTFilter(HandlerExceptionResolver handlerExceptionResolver)
    {
        this.handlerExceptionResolver=handlerExceptionResolver;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
        try {
            String authHeader = request.getHeader("Authorization");
            String email = null;
            String token = null;

            if (authHeader != null && authHeader.startsWith("Bearer "))
            {
                token = authHeader.substring(7);
                email = jwtService.extractEmail(token);
            }

            if (email != null && SecurityContextHolder.getContext().getAuthentication() == null)
            {
                UserDetails userDetails = context.getBean(MyUserDetailsService.class).loadUserByUsername(email);

                if (jwtService.validateToken(token, userDetails))
                {
                    UsernamePasswordAuthenticationToken token1=
                            new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                    token1.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(token1);
                }
            }
            filterChain.doFilter(request,response);
        }
        catch(Exception exception)
        {
            handlerExceptionResolver.resolveException(request,response,null,exception);
        }
    }
}
