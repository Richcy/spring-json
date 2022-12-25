package com.rapidtech.springjson.repository;

import com.rapidtech.springjson.entity.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepo extends JpaRepository<SchoolEntity, Long> {
}
