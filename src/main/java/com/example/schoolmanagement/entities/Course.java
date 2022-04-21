package com.example.schoolmanagement.entities;

import lombok.*;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "course")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "course_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private Integer unit;

    @NonNull
    @ManyToMany
    @JoinTable(
            name = "student_enrolled",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> enrolledStudents;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "professor_id",
            referencedColumnName = "id"
    )
    private Professor professor;

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unit=" + unit +
                ", enrolledStudents=" + enrolledStudents +
                ", professor=" + professor +
                '}';
    }
}
