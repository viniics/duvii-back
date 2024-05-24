package com.example.app.controllers;


import com.example.app.dto.UserPostDto;
import com.example.app.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping(
        value = "/user", produces = MediaType.APPLICATION_JSON_VALUE
)
public class UserRestController {
    @Autowired
    UserService userService;


    @PostMapping("/post")
    ResponseEntity<?> createUser(
            @RequestBody @Valid UserPostDto userPostDto
            ){
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.registerUser(userPostDto));
    }
}
