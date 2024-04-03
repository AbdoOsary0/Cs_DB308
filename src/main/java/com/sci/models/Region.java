package com.sci.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "regions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Region implements Serializable {
    @Serial
    private static final long serialVersionUID = -915428707036605461L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Regions_gen")
    @Column(name = "region_id")
    private Integer regionId;
    @Column(name = "region_name")
    private String regionName;
}
