package com.hashworks.MyApp.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import com.hashworks.MyApp.model.Users;

@Repository
public class OAuthDataAccess {
   @Autowired
   private JdbcTemplate jdbcTemplate;

   public Users getUserDetails(String username) {
      Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
      String SQL = "SELECT * FROM USERS WHERE USERNAME=?";
      List<Users> list = jdbcTemplate.query(SQL, new String[] { username },
         (ResultSet rs, int rowNum) -> {
         
         Users user = new Users();
         user.setUsername(username);
         user.setPassword(rs.getString("PASSWORD"));
         return user;
      });
      if (list.size() > 0) {
         GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_SYSTEMADMIN");
         grantedAuthoritiesList.add(grantedAuthority);
         list.get(0).setGrantedAuthoritiesList(grantedAuthoritiesList);
         return list.get(0);
      }
      return null;
   }
} 
