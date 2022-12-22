package com.rapidtech.springjson.controller;

import com.rapidtech.springjson.model.CustomerModel;
import com.rapidtech.springjson.model.CustomerRequest;
import com.rapidtech.springjson.model.ResponseModel;
import com.rapidtech.springjson.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/customers")
@RestController
public class CustomerController {
    private CustomerService service;
    @Autowired
    public CustomerController(CustomerService service){
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<Object> get(){
        List<CustomerModel> result = service.getAll();
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS",result)
                );
    }
    @PostMapping
    public ResponseEntity<Object> saveCustomer(@RequestBody CustomerModel request){
        Optional<CustomerModel> result = service.save(request);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS",result)
        );
    }
}
