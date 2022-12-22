package com.rapidtech.springjson.entity;

import com.rapidtech.springjson.model.SchoolModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "school_tab")
public class SchoolEntity {
    @Id
    @TableGenerator(name = "school_id_generator", table = "sequence_tab",
    pkColumnName = "gen_name", valueColumnName = "gen_value",
    pkColumnValue = "school_id", initialValue = 0, allocationSize = 0)

    @Column(name = "title", length = 20)
    private String title;
    @Column(name = "school_name", length = 100)
    private String name;
    @Column(name = "level", length = 20)
    private String level;

    public SchoolEntity(SchoolModel model) {
        BeanUtils.copyProperties(model,this);
    }
}
