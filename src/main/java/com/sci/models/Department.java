package com.sci.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "Departments")
@Data
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "departments_gen", sequenceName = "hr.departments_seq", allocationSize = 1)
public class Department implements Serializable {


    @Serial
    private static final long serialVersionUID = -915428707036605461L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employees_gen")
    @Column(name = "department_id")
    private Integer depart_id;
    @Column(name = "department_name")
    private String departmentName;
    @Column(name = "manager_id")
    private Integer managerId;
    @Column(name = "location_id")
    private Integer locationId;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "department_id", insertable = false, updatable = false)
//    private List<Employee> List_employees;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", insertable = false,updatable = false)
    private Location locations;


}


