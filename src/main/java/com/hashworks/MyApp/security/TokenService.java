package com.hashworks.MyApp.security;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import static java.util.Collections.emptyList;

public class TokenService {
	 static final long EXPIRATIONTIME = 864_000_000; // 10 days
	 static final String SECRET = "SherlockHolmes";
	 static final String TOKEN_PREFIX = "Bearer";
	 static final String HEADER_STRING = "Authorization";
	 
	 static void addAuthentication(HttpServletResponse res, String username) {
		 //HERE I'M CREATING A JWT WHEN I USER SIGN IN SUCCESSFULLY
		    String JWT = Jwts.builder()
		        .setSubject(username)
		        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
		        .signWith(SignatureAlgorithm.HS512, SECRET)
		        .compact();
		    res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
		  }
	 
	 static UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
		    String token = request.getHeader(HEADER_STRING);
		    if (token != null) {
		      // parse the token.
		      String user = Jwts.parser()
		          .setSigningKey(SECRET)
		          .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
		          .getBody()
		          .getSubject();		      
		      return user != null ?
	                    new UsernamePasswordAuthenticationToken(user, null, emptyList()) :
	                    null;
	        }
	        return null;

	 }
}