package com.rapidtech.springjson.model;

import com.rapidtech.springjson.entity.LocationEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationModel implements Serializable {
    private Long id;
    private String name;
    private String address;
    private String district;
    private String city;
    private String province;
    private String village;

    public LocationModel(LocationEntity entity) {
        BeanUtils.copyProperties(entity,this);
    }
}
