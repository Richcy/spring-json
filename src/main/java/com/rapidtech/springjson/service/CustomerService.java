package com.rapidtech.springjson.service;

import com.rapidtech.springjson.model.CustomerModel;
import com.rapidtech.springjson.model.CustomerRequest;
import com.rapidtech.springjson.model.CustomerResponse;

import java.util.Optional;
import java.util.List;


public interface CustomerService {
    List<CustomerModel> getAll();
    Optional<CustomerModel> getById(Long id);
    CustomerResponse saveAll(CustomerRequest request);
    Optional<CustomerModel> save(CustomerModel model);
    Optional<CustomerModel> update(Long id, CustomerModel model);
    Optional<CustomerModel> delete(Long id);
}
