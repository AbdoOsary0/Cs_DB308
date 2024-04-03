package com.sci.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "locations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location implements Serializable {
    @Serial
    private static final long serialVersionUID = -915428707036605461L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Locations_gen")
    @Column(name = "location_id")
    private Integer locationId;
    @Column(name = "street_address")
    private String streetAddress;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "city")
    private String city;
    @Column(name = "state_province")
    private String stateProvince;
    @Column(name = "country_id")
    private String countryId;
}
