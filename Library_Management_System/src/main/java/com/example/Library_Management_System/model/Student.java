package com.example.Library_Management_System.model;

import com.example.Library_Management_System.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="Student_info")
public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        int regNo;
        @Column(name="Student_name")
        String name;
        @Enumerated(EnumType.STRING)
        Gender gender;
        int age;
        @Column(unique = true,nullable = false)
        String email;
        @OneToOne(mappedBy = "student" , cascade=CascadeType.ALL)
        LibraryCard libraryCard;
}
