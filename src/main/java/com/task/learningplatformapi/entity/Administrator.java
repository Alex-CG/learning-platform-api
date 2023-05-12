package com.task.learningplatformapi.entity;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "administrator")
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

}
