package com.example.demo_Eturia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


/**
 * Entity class representing a Course.
 * This class is annotated with JPA annotations to map it to a database table.
 * Lombok annotations are used to generate boilerplate code like getters,
 * setters, and constructors.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "courses")
public class Course {

    /**
     * The unique identifier for the Course.
     * This field is annotated with @Id to denote it as the primary key,
     * @GeneratedValue to indicate the generation strategy for the primary key,
     * and @Column to specify the column name in the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * The name of the Course.
     * This field stores the name of the course.
     */
    @Column(name = "name")
    private String name;

    /**
     * The description of the Course.
     * This field stores the description of the course.
     */
    @Column(name = "description")
    private String description;

    /**
     * The students associated with the Course.
     * This field is annotated with @ManyToMany(mappedBy = "courses") to denote the
     * many-to-many relationship with the Student entity and the owning side.
     */
    @ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER)
    private Set<Student> students;
}