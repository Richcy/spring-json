package com.rapidtech.springjson.service.impl;

import com.rapidtech.springjson.entity.CustomerEntity;
import com.rapidtech.springjson.entity.LocationEntity;
import com.rapidtech.springjson.entity.SchoolEntity;
import com.rapidtech.springjson.model.CustomerModel;
import com.rapidtech.springjson.model.LocationModel;
import com.rapidtech.springjson.model.SchoolModel;
import com.rapidtech.springjson.repository.CustomerRepo;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Address;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;

import java.util.*;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {
    @InjectMocks
    @Autowired
    private CustomerServiceImpl service;
    @Mock
    private CustomerRepo repo;
    private List<CustomerEntity> customerEntityList;

    @BeforeEach
    void setUp() {
        log.info("Setup Run ....");
        customerEntityList = Arrays.asList(
                new CustomerEntity(1L,"Customer1", "Wanita"),
                new CustomerEntity(2L,"Customer2","Pria"),
                new CustomerEntity(3L,"Customer3","Pria")
        );
    }

    @AfterEach
    void tearDown() {
        log.info("Setup Clear ....");
    }

    @Test
    void getAll() {
        when(this.repo.findAll()).thenReturn(Collections.emptyList());
        List<CustomerModel> result = service.getAll();
        assertNotNull(result);
        assertEquals(0,result.size());

        when(this.repo.findAll()).thenReturn(customerEntityList);
        result = service.getAll();
        assertNotNull(result);
        assertEquals(3,result.size());
        assertEquals(1L,result.get(0).getId());
        assertEquals("Customer1",result.get(0).getFullName());
        assertEquals("Wanita",result.get(0).getGender());
    }

    @Test
    void getById(){
        Optional<CustomerModel> result = service.getById(0L);
        assertEquals(Optional.empty(),result);

        CustomerEntity customerEntity = new CustomerEntity(1L,"Customer1","Wanita");
        Optional<CustomerEntity> optional = Optional.of(customerEntity);

        when(repo.findById(1L));

        assertTrue(result.isPresent());
        assertEquals(1L,result.get().getId());
        assertEquals("Customer1",result.get().getFullName());
        assertEquals("Wanita",result.get().getGender());
    }

    @Test
    void saveAll() {
    }

    @Test
    void save() {
        Optional<CustomerModel> result = this.service.save(null);
        assertEquals(Optional.empty(),result);
        List<LocationModel> locationModels = Arrays.asList(
                new LocationModel(0L,"Location 1","Jl. Jalan 1","Sukahurip","Pamarican","Ciamis","Jawa Barat"),
                new LocationModel(0L,"Location 2","Jl. Jalan 1","Sukahurip","Pamarican","Ciamis","Jawa Barat")
        );

        List<SchoolModel> schoolModels = Arrays.asList(
                new SchoolModel(0L,"SD","SDN 1 Test","SD"),
                new SchoolModel(0L,"SMP","SMP 1 Test","SMP"),
                new SchoolModel(0L,"SMA","SMA 1 Test","SMA")
        );

        CustomerModel model = new CustomerModel(1L,"Joko",locationModels,"Pria",new Date(),"Jakarta",
                schoolModels
        );

        CustomerEntity entity = new CustomerEntity(model);
        List<LocationEntity> locationEntities = locationModels.stream().map(LocationEntity::new).collect(Collectors.toList());
        entity.setLocation(locationEntities);

        List<SchoolEntity> schoolEntities = schoolModels.stream().map(SchoolEntity::new).collect(Collectors.toList());
        entity.setSchool(schoolEntities);

        when(this.repo.save(any(CustomerEntity.class))).thenReturn(entity);
        result = this.service.save(model);
        assertNotNull(result);
        assertEquals("Joko",result.get().getFullName());
        assertEquals("Pria",result.get().getGender());
        assertEquals("Jakarta",result.get().getPlaceOfBirth());

        assertEquals(2,result.get().getLocation().size());
        assertEquals(3,result.get().getSchools().size());
    }
}