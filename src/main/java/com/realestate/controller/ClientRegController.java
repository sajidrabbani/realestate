package com.realestate.controller;

import com.realestate.payload.ClientRegDto;
import com.realestate.service.ClientRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientreg")
public class ClientRegController {

    @Autowired
    private ClientRegService clientRegService;

    //http://localhost:8080/api/clientreg/create
    @PostMapping("/create")
    public ResponseEntity<String> saveClient(@RequestBody ClientRegDto clientRegDto) {
    clientRegService.saveUser(clientRegDto);

        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }
}
