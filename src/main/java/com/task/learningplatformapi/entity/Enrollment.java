package com.task.learningplatformapi.entity;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "enrollment")
public class Enrollment {

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
