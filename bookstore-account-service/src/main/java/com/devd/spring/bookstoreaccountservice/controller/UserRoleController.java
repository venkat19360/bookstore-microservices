package com.devd.spring.bookstoreaccountservice.controller;

import com.devd.spring.bookstoreaccountservice.service.UserRoleService;
import com.devd.spring.bookstoreaccountservice.web.MapRoleToUsersRequest;
import com.devd.spring.bookstoreaccountservice.web.MapUserToRolesRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Devaraj Reddy, Date : 2019-06-30
 */
@RestController
public class UserRoleController {

  @Autowired
  UserRoleService userRoleService;

  @GetMapping("/test/user-role")
  public ResponseEntity<String> testUserRoleController() {
    return ResponseEntity.ok("Hey, I am UserRoleController");
  }

  @PostMapping("/user/{userNameOrEmail}/roles")
  public void mapUserToRoles(@PathVariable("userNameOrEmail") String userNameOrEmail,
      @RequestBody @Valid MapUserToRolesRequest mapUserToRolesRequest) {

    userRoleService.mapUserToRoles(userNameOrEmail, mapUserToRolesRequest);

  }

  @PostMapping("/role/{roleName}/users")
  public void mapRoleToUsers(@PathVariable("roleName") String roleName,
      @RequestBody @Valid MapRoleToUsersRequest mapRoleToUsersRequest) {

    userRoleService.mapRoleToUsers(roleName, mapRoleToUsersRequest);

  }
}
