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
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Long id){
        Optional<CustomerModel> result = service.getById(id);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS",result)
        );
    }
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody CustomerRequest request){
        //Optional<CustomerModel> result = service.save(request);
        return ResponseEntity.ok().body(
                service.saveAll(request)
        );
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerModel request){
        Optional<CustomerModel> result = service.update(id, request);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS",result)
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id){
        Optional<CustomerModel> result = service.delete(id);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS",result)
        );
    }
}
