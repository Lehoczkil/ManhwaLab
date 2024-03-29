package com.codecool.manhwalabbackend.security;

import com.codecool.manhwalabbackend.model.roles.ApplicationUserRoles;
import com.codecool.manhwalabbackend.security.jwt.JwtTokenVerifier;
import com.codecool.manhwalabbackend.security.jwt.JwtUsernamePasswordAuthenticationFilter;
import com.codecool.manhwalabbackend.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final UserProfileService appUserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors().configurationSource(corsConfigurationSource())
                .and()
                .addFilter(new JwtUsernamePasswordAuthenticationFilter(authenticationManager()))
                .addFilterAfter(new JwtTokenVerifier(), JwtUsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/api/manhwaLab/top/**", "/api/manhwaLab/manhwaList", "/api/manhwaLab/*/update-view", "/api/manhwaLab/genres", "/api/manhwaLab/themes", "/api/manhwaLab/types", "/api/manhwaLab/registration", "/login", "/registration", "/images/*", "/api/manhwaLab/*/recommendations", "/api/manhwaLab/comments/*", "/api/manhwaLab/replies/*").permitAll()
                .antMatchers("/api/manhwaLab/profile").hasRole(ApplicationUserRoles.USER.name())
                .antMatchers("/api/manhwaLab/addToUser", "/api/manhwaLab/addToReading", "/api/manhwaLab/addToReadLater", "/api/manhwaLab/addToFinished", "/api/manhwaLab/addToFavourites", "/api/manhwaLab/add-comment/*", "/api/manhwaLab/delete-comment/*", "/api/manhwaLab/edit-comment/*", "/api/manhwaLab/add-reply/*").hasRole(ApplicationUserRoles.USER.name())
                .antMatchers("/api/manhwaLab/removeFromReading", "/api/manhwaLab/removeFromReadLater", "/api/manhwaLab/removeFromFinished", "/api/manhwaLab/removeFromFavourites").hasRole(ApplicationUserRoles.USER.name())
                .anyRequest()
                .authenticated();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(appUserService);
        return provider;
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:8081"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PATCH", "PUT", "DELETE"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
