package com.devd.spring.bookstoreaccountservice.controller;

import com.devd.spring.bookstoreaccountservice.service.AuthService;
import com.devd.spring.bookstoreaccountservice.web.CreateOAuthClientRequest;
import com.devd.spring.bookstoreaccountservice.web.CreateOAuthClientResponse;
import com.devd.spring.bookstoreaccountservice.web.CreateUserResponse;
import com.devd.spring.bookstoreaccountservice.web.JwtAuthenticationResponse;
import com.devd.spring.bookstoreaccountservice.web.SignInRequest;
import com.devd.spring.bookstoreaccountservice.web.SignUpRequest;
import java.net.URI;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @author: Devaraj Reddy, Date : 2019-05-18
 */
@RestController
public class AuthController {

  @Autowired
  AuthService authService;

  @GetMapping("/test/auth")
  public ResponseEntity<String> testAuthController() {
    return ResponseEntity.ok("Hey, I am AuthController");
  }

  @PostMapping("/client")
  @PreAuthorize("hasAuthority('ADMIN_USER')")
  public ResponseEntity<CreateOAuthClientResponse> createOAuthClient(
      @Valid @RequestBody CreateOAuthClientRequest createOAuthClientRequest) {

    CreateOAuthClientResponse oAuthClient = authService.createOAuthClient(createOAuthClientRequest);
    return new ResponseEntity<>(oAuthClient, HttpStatus.CREATED);
  }

  @PostMapping("/signin")
  public ResponseEntity<JwtAuthenticationResponse> authenticateUser(
      @Valid @RequestBody SignInRequest signInRequest) {

    String accessToken = authService.authenticateUser(signInRequest);
    return ResponseEntity.ok(new JwtAuthenticationResponse(accessToken));
  }

  @PostMapping("/signup")
  @PreAuthorize("hasAuthority('ADMIN_USER')")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

    CreateUserResponse createUserResponse = authService.registerUser(signUpRequest);

    return new ResponseEntity<>(createUserResponse, HttpStatus.CREATED);
  }
}
