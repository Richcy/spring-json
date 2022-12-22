package com.rapidtech.springjson.model;

import com.rapidtech.springjson.entity.SchoolEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolModel implements Serializable {
    private String title;
    private String name;
    private String level;

    public SchoolModel(SchoolEntity entity) {
        BeanUtils.copyProperties(entity,this);
    }
}
