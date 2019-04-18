package pl.lukas.jpa.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String telephone;

    @Embedded
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    private Indeks indeks;

    @ManyToOne
    private University university;

    @ManyToMany
    private Set<Classes> classes;

    public Student(String name, String indeksNumber) {
        this.name = name;
        this.indeks = new Indeks(indeksNumber);
        this.classes = new HashSet<>();
    }

    public void setIndeks(Indeks indeks) {
        this.indeks = indeks;
    }

    public Student() {
    }

    public Student(String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{ " +
                "id = " + id +
                ", name = '" + name + '\'' +
//                ", indeks = " + indeks +
                '}';
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public void setClasses (Classes classes) {
        this.classes.add(classes);
    }
}