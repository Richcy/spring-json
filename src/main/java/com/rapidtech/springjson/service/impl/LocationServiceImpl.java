package com.rapidtech.springjson.service.impl;

import com.rapidtech.springjson.entity.LocationEntity;
import com.rapidtech.springjson.model.LocationModel;
import com.rapidtech.springjson.repository.LocationRepo;
import com.rapidtech.springjson.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.SequenceGenerator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class LocationServiceImpl implements LocationService {
    private LocationRepo repo;
    @Autowired
    public LocationServiceImpl(LocationRepo repo){
        this.repo = repo;
    }
    @Override
    public List<LocationModel> getAll(){
        return this.repo.findAll().stream().map(LocationModel::new)
                .collect(Collectors.toList());
    }
    @Override
    public Optional<LocationModel> save(LocationModel model){
        if(model == null){
            return Optional.empty();
        }
        LocationEntity entity = new LocationEntity(model);
        try{
            this.repo.save(entity);
            return Optional.of(new LocationModel(entity));
        }catch (Exception e){
            log.error("Location save is failed, error {}", e.getMessage());
            return Optional.empty();
        }
    }
}
