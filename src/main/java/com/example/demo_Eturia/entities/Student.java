package com.example.demo_Eturia.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    /**
     * The unique identifier for the Student.
     * This field is annotated with @Id to denote it as the primary key,
     * @GeneratedValue to indicate the generation strategy for the primary key,
     * and @Column to specify the column name in the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * The name of the Student.
     * This field stores the name of the student.
     */
    @Column(name = "name")
    private String name;

    /**
     * The age of the Student.
     * This field stores the age of the student.
     */
    @Column(name = "age")
    private int age;

    /**
     * The courses associated with the Student.
     * This field is annotated with @ManyToMany to denote a many-to-many relationship
     * with the Course entity, and @JoinTable to specify the join table and columns.
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "student_course",
        joinColumns = { @JoinColumn(name = "student_id") },
        inverseJoinColumns = { @JoinColumn(name = "course_id") }
    )
    private Set<Course> courses;
}
