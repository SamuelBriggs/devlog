//package com.devlog.security;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//
//@AllArgsConstructor
//@Slf4j
//@Service
//public class AuthSuccessHandler implements AuthenticationSuccessHandler {
//
//
//
//        @Override
//        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException, IOException {
//            // if (request.getRequestURI().equals("/api/v1/user/"))
//            log.info(request.getHeader("Referer"));
//            log.info(request.getRequestURI()
//            );
//            OAuth2User userDetails = (OAuth2User) authentication.getPrincipal();
//            String email = (String) userDetails.getAttributes().get("email");
//            System.out.println(email);
//                response.sendRedirect("http://localhost:3000/loginRedirect?token="+email);}
//
//        }
//
////
//
//
//
//
//
