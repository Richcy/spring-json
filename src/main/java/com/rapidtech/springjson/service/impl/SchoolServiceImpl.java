package com.rapidtech.springjson.service.impl;

import com.rapidtech.springjson.entity.SchoolEntity;
import com.rapidtech.springjson.model.SchoolModel;
import com.rapidtech.springjson.repository.SchoolRepo;
import com.rapidtech.springjson.service.SchoolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SchoolServiceImpl implements SchoolService {
    private SchoolRepo repo;
    @Autowired
    public SchoolServiceImpl(SchoolRepo repo){
        this.repo = repo;
    }
    @Override
    public List<SchoolModel> getAll(){
        return this.repo.findAll().stream().map(SchoolModel::new)
                .collect(Collectors.toList());
    }
    @Override
    public Optional<SchoolModel> save(SchoolModel model){
        if(model == null){
            return Optional.empty();
        }
        SchoolEntity entity = new SchoolEntity(model);
        try {
            this.repo.save(entity);
            return Optional.of(new SchoolModel(entity));
        }catch (Exception e){
            log.error("School sace is failed, error {}",e.getMessage());
            return Optional.empty();
        }
    }
}
