package com.sci.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

final class CompositeKey implements Serializable {
    @Serial
    private static final long serialVersionUID = -915428707036605461L;
    private Integer employee_id;
    private Date start_date;
}

@Entity
@Table(name = "job_History")
@Data
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "job_History_gen", sequenceName = "hr.job_History_seq", allocationSize = 1)
public class Job_History implements Serializable {
    @Serial
    private static final long serialVersionUID = -915428707036605461L;
    @Id
    @Column(name = "Employee_id")
    private Integer employeeId;
    @Id
    @Column(name = "Start_Date")
    private Date startDate;
    @Column(name = "department_id")
    private Integer departmentId;
    @Column(name = "Job_id")
    private Integer jobId;
    @Column(name = "End_Date")
    private Date endDate;
}
