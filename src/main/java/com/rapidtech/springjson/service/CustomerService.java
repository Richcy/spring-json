package com.rapidtech.springjson.service;

import com.rapidtech.springjson.model.CustomerModel;

import java.util.Optional;
import java.util.List;


public interface CustomerService {
    List<CustomerModel> getAll();
    Optional<CustomerModel> save(CustomerModel model);
}
