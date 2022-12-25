package com.rapidtech.springjson.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rapidtech.springjson.model.SchoolModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "school_id_generator")
    private Long id;
    @Column (name = "customer_id", updatable = false, insertable = false)
    private Long costumerId;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

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
