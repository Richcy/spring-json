package com.rapidtech.springjson.service;

import com.rapidtech.springjson.model.SchoolModel;

import java.util.List;
import java.util.Optional;

public interface SchoolService {
    List<SchoolModel> getAll();
    Optional<SchoolModel> save(SchoolModel model);
}
