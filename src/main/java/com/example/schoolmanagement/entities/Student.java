package com.example.schoolmanagement.entities;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(
        name = "student",
        uniqueConstraints = {
                @UniqueConstraint(name = "student_id_unique", columnNames = "student_id"),
                @UniqueConstraint(name = "national_id_unique", columnNames = "national_id")
        }
)
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "student_sequence"

    )
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "student_id",nullable = false)
    private Long studentId;

    @NonNull
    @Column(nullable = false, columnDefinition = "TEXT")
    private String firstName;

    @NonNull
    @Column(nullable = false, columnDefinition = "TEXT")
    private String lastName;

    @NonNull
    @Column(name = "national_id", nullable = false)
    private Long nationalId;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalId=" + nationalId +
                '}';
    }
}
