package com.rapidtech.springjson.service.impl;

import com.rapidtech.springjson.entity.CustomerEntity;
import com.rapidtech.springjson.model.CustomerModel;
import com.rapidtech.springjson.repository.CustomerRepo;
import com.rapidtech.springjson.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepo repo;
    @Autowired
    public CustomerServiceImpl(CustomerRepo repo){
        this.repo = repo;
    }
    @Override
    public List<CustomerModel> getAll(){
        return this.repo.findAll().stream().map(CustomerModel::new)
                .collect(Collectors.toList());
    }
    @Override
    public Optional<CustomerModel> save(CustomerModel model){
        if(model == null){
            return Optional.empty();
        }
        CustomerEntity entity = new CustomerEntity(model);
        try{
            this.repo.save(entity);
            return Optional.of(new CustomerModel(entity));
        }catch (Exception e){
            log.error("Customer save is failed, error {}", e.getMessage());
            return Optional.empty();
        }
    }
}
