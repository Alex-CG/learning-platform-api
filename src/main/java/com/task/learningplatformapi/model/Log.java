package com.task.learningplatformapi.model;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "log")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "enrollment_id")
    private Enrollment enrollment;

    @Column(name = "log_date", nullable = false)
    private LocalDate logDate;

    @Column(name = "task_category")
    private String taskCategory;

    @Column(name = "task_description")
    private String taskDescription;

    @Column(name = "time_spent")
    private String timeSpent;

}
