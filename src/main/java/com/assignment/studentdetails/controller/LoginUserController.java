package com.assignment.studentdetails.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.studentdetails.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginUserController.
 */
@RestController
@RequestMapping(value = "/api/v1/user")
public class LoginUserController {
	
	 /**
 	 * Login.
 	 *
 	 * @param username the username
 	 * @param pwd the pwd
 	 * @return the user
 	 */
 	@PostMapping("/login")
	    public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {

	        String token = getJWTToken(username);
	        User user = new User();
	        user.setUser(username);
	        user.setToken(token);
	        return user;

	    }
	 
	 
	 /**
 	 * Gets the JWT token.
 	 *
 	 * @param username the username
 	 * @return the JWT token
 	 */
 	private String getJWTToken(String username) {
	        String secretKey = "mySecretKey";
	        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
	                .commaSeparatedStringToAuthorityList("ROLE_USER");

	        String token = Jwts
	                .builder()
	                .setId("softtekJWT")
	                .setSubject(username)
	                .claim("authorities",
	                        grantedAuthorities.stream()
	                                .map(GrantedAuthority::getAuthority)
	                                .collect(Collectors.toList()))
	                .setIssuedAt(new Date(System.currentTimeMillis()))
	                .setExpiration(new Date(System.currentTimeMillis() + 600000))
	                .signWith(SignatureAlgorithm.HS512,
	                        secretKey.getBytes()).compact();

	        return "Bearer " + token;
	    }
}
