package com.hashworks.MyApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hashworks.MyApp.Repository.OAuthDataAccess;
import com.hashworks.MyApp.model.Users;

@Service
public class CustomDetailsService implements UserDetailsService {
   @Autowired
   OAuthDataAccess dao;

   @Override
   public CustomUser loadUserByUsername(final String username) throws UsernameNotFoundException {
      Users users = null;
      try {
         users = dao.getUserDetails(username);
         CustomUser customUser = new CustomUser(users);
         return customUser;
      } catch (Exception e) {
         e.printStackTrace();
         throw new UsernameNotFoundException("User " + username + " was not found in the database");
      }
   }
}
