package pl.lukas.jpa.domain;

import javax.persistence.*;

@Gett
@Entity
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

    @ManyToOne()
    private University university;

    public Student(String name, String indeksNumber) {
        this.name = name;
        this.indeks = new Indeks(indeksNumber);
    }

    public Indeks getIndeks() {
        return indeks;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
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
}