package com.rapidtech.springjson.entity;

import com.rapidtech.springjson.model.LocationModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "location_tab")
public class LocationEntity {
    @Id
    @TableGenerator(name = "location_id_generator", table = "sequence_tab",
    pkColumnName = "gen_name", valueColumnName = "gen_value",
    pkColumnValue = "location_id", initialValue = 0, allocationSize = 0)
    private Long id;
    @Column(name = "location_name", length = 50)
    private String name;
    @Column(name = "address", length = 100)
    private String address;
    @Column(name = "village", length = 100)
    private String village;
    @Column(name = "district", length = 100)
    private String district;
    @Column(name = "city", length = 50)
    private String city;
    @Column(name = "province", length = 100)
    private String province;

    public LocationEntity(LocationModel model) {
        BeanUtils.copyProperties(model,this);
    }
}
