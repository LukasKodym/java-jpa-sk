package pl.lukas.jpa.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @OneToMany
    private Set<Student> students;

    protected University() {
    }

    public University(String name) {
        this.students = new HashSet<>();
        this.name = name;
    }

    public void addStudent(Student student){
        students.add(student);
    }
}
