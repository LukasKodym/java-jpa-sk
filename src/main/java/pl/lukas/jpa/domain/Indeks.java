package pl.lukas.jpa.domain;

import javax.persistence.*;

@Entity
public class Indeks {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String number;

    @OneToOne(mappedBy = "indeks")
    private Student owner;

    protected Indeks() {
    }

    public Indeks(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String name) {
        this.number = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getOwner() {
        return owner;
    }

    public void setOwner(Student owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Indeks{ " +
                "id = " + id +
                ", number = '" + number + '\'' +
//                ", owner = " + owner +
                '}';
    }
}