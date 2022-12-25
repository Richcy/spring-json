package com.rapidtech.springjson.controller;

import com.rapidtech.springjson.model.ResponseModel;
import com.rapidtech.springjson.model.SchoolModel;
import com.rapidtech.springjson.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/schools")
@RestController
public class SchoolController {
    private SchoolService service;
    @Autowired
    public  SchoolController(SchoolService service){
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<Object> get(){
        List<SchoolModel> result = service.getAll();
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS",result)
        );
    }
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody SchoolModel request){
        Optional<SchoolModel> result = service.save(request);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS",result)
        );
    }
}
