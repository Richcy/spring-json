package com.rapidtech.springjson.model;

import com.rapidtech.springjson.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerModel {
    private Long id;
    private String fullName;
    private List<LocationModel> address;
    private String gender;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String placeOfBirth;
    private List<SchoolModel> schools;

    public CustomerModel(CustomerEntity entity) {
        BeanUtils.copyProperties(entity,this);
    }
}
