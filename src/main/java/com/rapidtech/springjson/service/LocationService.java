package com.rapidtech.springjson.service;

import com.rapidtech.springjson.model.LocationModel;

import java.util.List;
import java.util.Optional;

public interface LocationService {
    List<LocationModel> getAll();
    Optional<LocationModel> save(LocationModel model);
}
