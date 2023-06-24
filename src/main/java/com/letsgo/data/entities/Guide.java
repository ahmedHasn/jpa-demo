package com.letsgo.data.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import static jakarta.persistence.CascadeType.PERSIST;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "guide")
@EntityListeners({AuditingEntityListener.class})
public class Guide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal salary;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "guide", cascade = PERSIST)
    private Set<Student> students;

    @Version
    private Integer version;

    public void addStudent(final Student student){
        this.students.add(student);
        student.setGuide(this);
    }

    public void removeStudent(final Student student){
        this.students.remove(student);
        student.setGuide(null);
    }
}
