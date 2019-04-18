package pl.lukas.jpa.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "classes")
    private Set<Student> students;

    public Classes(String name) {
        this.students = new HashSet<>();
        this.name = name;
    }

    public void addStudent (Student student){
        students.add(student);
    }
}
