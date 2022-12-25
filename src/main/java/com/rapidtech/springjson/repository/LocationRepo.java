package com.rapidtech.springjson.repository;

import com.rapidtech.springjson.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepo extends JpaRepository<LocationEntity, Long> {
}
