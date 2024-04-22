package com.sci.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
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
    @Column(name = "employee_id")
    private Integer employeeId;
    @Id
    @Column(name = "Start_Date")
    private Date startDate;
    @Column(name = "department_id")
    private Integer departmentId;
    @Column(name = "job_id")
    private Integer jobId;
    @Column(name = "End_Date")
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", insertable = false,updatable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", insertable = false,updatable = false)
    private Job job;

}
