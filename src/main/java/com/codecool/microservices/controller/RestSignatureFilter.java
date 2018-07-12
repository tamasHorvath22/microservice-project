package com.codecool.microservices.controller;

import com.codecool.microservices.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class RestSignatureFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpSession session= httpServletRequest.getSession();
        try {
            if (session.getAttribute("user") == null) {
                session.setAttribute("user", new User(0L, "none", "none", "none", "none", "none"));
                return;
            }
        } catch (Exception e) {
            httpServletResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "The REST Security Server experienced an internal error.");
            return;
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
