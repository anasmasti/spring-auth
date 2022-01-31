package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.AppUser;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class AppUserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "")
    public ResponseEntity<List<AppUser>> getUsers() {
        return new ResponseEntity<List<AppUser>>(userService.getUsers(), HttpStatus.OK);
    }

    @PostMapping(path = "")
    public ResponseEntity<AppUser> addUser(@RequestBody AppUser appUser) {
        return new ResponseEntity<AppUser>(userService.postUser(appUser), HttpStatus.CREATED);
    }
}
