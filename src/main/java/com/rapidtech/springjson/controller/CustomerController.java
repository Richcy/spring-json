package com.rapidtech.springjson.controller;

import com.rapidtech.springjson.model.CustomerRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/customers")
@RestController
public class CustomerController {
    @PostMapping
    public ResponseEntity<Object> saveCustomer(@RequestBody CustomerRequest request){
        return ResponseEntity.ok().body(request);
    }
}
