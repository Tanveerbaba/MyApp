package com.hashworks.MyApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebConfig extends WebSecurityConfigurerAdapter {
   @Autowired
   private CustomDetailsService customDetailsService;

   @Bean
   public PasswordEncoder encoder() {
      return new BCryptPasswordEncoder();
   }
   
   @Override
   @Autowired
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	   JDBC Authentication
      auth.userDetailsService(customDetailsService).passwordEncoder(encoder());
   }
   
   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests().anyRequest().authenticated().and().sessionManagement()
         .sessionCreationPolicy(SessionCreationPolicy.NEVER);
   }
   
   @Override
   @Bean
   // NEEDS TO BE EXPOSED FOR AuthenticationManagerBuilder
   public AuthenticationManager authenticationManagerBean() throws Exception {
      return super.authenticationManagerBean();
   }
} 