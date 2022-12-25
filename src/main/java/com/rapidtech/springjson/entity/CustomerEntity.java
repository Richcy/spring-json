package com.rapidtech.springjson.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rapidtech.springjson.model.CustomerModel;
import com.rapidtech.springjson.model.LocationModel;
import com.rapidtech.springjson.model.SchoolModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customer_tab")
public class CustomerEntity {
    @Id
    @TableGenerator(name = "customer_id_generator", table = "sequence_tab",
    pkColumnName = "gen_name", valueColumnName = "gen_value",
    pkColumnValue = "customer_id", initialValue = 0, allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "customer_id_generator")
    private Long id;
    @Column(name = "customer_name", length = 100)
    private String fullName;
    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<LocationEntity> location = new ArrayList<>();
    @Column(name = "gender", length = 20)
    private String gender;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "place_of_birth", length = 100)
    private String placeOfBirth;
    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<SchoolEntity> school = new ArrayList<>();

    public CustomerEntity(CustomerModel model) {
        BeanUtils.copyProperties(model,this);
    }
    public CustomerEntity(Long id, String fullName, String gender){
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
    }
    public void addLocationList(List<LocationModel> models){
        for(LocationModel model: models){
            this.addLocation(new LocationEntity(model));
        }
    }
    public void addLocation(LocationEntity location){
        this.location.add(location);
        location.setCustomer(this);
    }
    public void addSchoolList(List<SchoolModel> models){
        for(SchoolModel model: models){
            this.addSchool(new SchoolEntity(model));
        }
    }
    public void addSchool(SchoolEntity school){
        this.school.add(school);
        school.setCustomer(this);
    }
}

