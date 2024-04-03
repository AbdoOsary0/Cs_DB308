package com.sci.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "jobs_gen", sequenceName = "hr.jobs_seq", allocationSize = 1)
public class Job implements Serializable {
    @Serial
    private static final long serialVersionUID = -915428707036605461L;
    @Id
    @Column(name = "job_id")
    private String jobId;
    @Column(name = "job_title")
    private String title;
    @Column(name = "min_salary")
    private Integer minSalary;
    @Column(name = "max_salary")
    private Integer maxSalary;
}
