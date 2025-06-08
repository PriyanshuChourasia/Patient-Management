package com.priyanshu.patient_service.config;


import com.priyanshu.patient_service.config.jwt.JwtAuthEntryPoint;
import com.priyanshu.patient_service.config.jwt.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    DataSource dataSource;

    @Autowired
    private JwtAuthEntryPoint unauthorizedHandler;

    @Bean
    public JwtFilter jwtAuthTokenFilter(){
        return new JwtFilter();
    };

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
//        These are interceptors and here we are permitting endpoints in requestmatchers to allow these points and any other request will be authenticated
        http.authorizeHttpRequests((requests)->
                requests.requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers("/api/signup").permitAll()
                        .requestMatchers("api/signin").permitAll()
                        .anyRequest().authenticated());
//        Session management for RESTAPIs
        http.sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        Exceptions handling
        http.exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler));
//        Form Login is for browser based application and for rest it should be off
//        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        http.headers(headers->
                headers.frameOptions(frameOptionsConfig ->
                        frameOptionsConfig.sameOrigin())
                );
        http.csrf(csrf-> csrf.disable());
        http.addFilterBefore(jwtAuthTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }




    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception{
        return builder.getAuthenticationManager();
    }
}
