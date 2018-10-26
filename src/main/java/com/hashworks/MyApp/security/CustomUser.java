package com.hashworks.MyApp.security;

import org.springframework.security.core.userdetails.User;

import com.hashworks.MyApp.model.Users;

// CLASS USER MODELS THE USER INFORMATION RETRIEVED BY USERDETAILSSERVICE. USES THE STATIC INNER CLASS BUILDER TO BUILD USER
public class CustomUser extends User {
   private static final long serialVersionUID = 1L;
   public CustomUser(Users user) {
      super(user.getUsername(), user.getPassword(), user.getGrantedAuthoritiesList());
   }
}
