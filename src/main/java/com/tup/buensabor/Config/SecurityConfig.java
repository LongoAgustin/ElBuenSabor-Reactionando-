package com.tup.buensabor.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.tup.buensabor.JWT.JWTAuthenticationFilter;

import java.util.List;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;

import lombok.RequiredArgsConstructor; 

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class SecurityConfig { //Security filter chain

    private final JWTAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
        .cors(Customizer.withDefaults())
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(authRequest -> 
            authRequest
                .requestMatchers(new AntPathRequestMatcher("/auth/**")).permitAll()
                .requestMatchers(PathRequest.toH2Console()).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/api/v1/ingredientes/admin/**")).hasAnyRole("ADMIN", "EMPLEADO")
                .requestMatchers(new AntPathRequestMatcher("/api/v1/pedido/admin/**")).hasAnyRole("ADMIN", "EMPLEADO")
                .requestMatchers(new AntPathRequestMatcher("/api/v1/productos/admin/**")).hasAnyRole("ADMIN", "EMPLEADO")
                .requestMatchers(new AntPathRequestMatcher("/api/v1/productos/list")).permitAll()
                .anyRequest().authenticated()
                )
            .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)) //H2
            .sessionManagement(sessionManager -> sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
    }    
    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedHeaders(List.of("Authorization", "Access-Control-Allow-Origin", "Content-Type",
        "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS"));
        configuration.setAllowedOrigins(List.of("http://localhost:5173"));
        configuration.setAllowCredentials(false);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}