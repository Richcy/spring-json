package com.rapidtech.springjson.controller;

import com.rapidtech.springjson.model.LocationModel;
import com.rapidtech.springjson.model.ResponseModel;
import com.rapidtech.springjson.service.LocationService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/locations")
@RestController
public class LocationController {
    private LocationService service;
    @Autowired
    public LocationController(LocationService service){
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<Object> get(){
        List<LocationModel> result = service.getAll();
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS",result)
        );
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody LocationModel request){
        Optional<LocationModel> result = service.save(request);
        return ResponseEntity.ok().body(
                new ResponseModel(200,"SUCCESS",result)
        );
    }
}
