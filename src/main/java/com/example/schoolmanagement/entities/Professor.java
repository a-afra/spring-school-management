package com.example.schoolmanagement.entities;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(
        name = "professor",
        uniqueConstraints = {
                @UniqueConstraint(name = "personnel_id_unique", columnNames = "personnel_id"),
                @UniqueConstraint(name = "prof_national_id_unique", columnNames = "national_id")
        }
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Professor {

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

    @NonNull
    @Column(name = "personnel_id",nullable = false)
    private Long personnelId;

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
        return "professor{" +
                "id=" + id +
                ", personnelId=" + personnelId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalId=" + nationalId +
                '}';
    }
}
