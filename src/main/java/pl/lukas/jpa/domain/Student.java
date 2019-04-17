package pl.lukas.jpa.domain;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    private int id;
    private String name;

    private String telephone;

    @Embedded
    private Address address;


    public Student() {
    }

    public Student(int id, String name) {
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
        return "Student{" +
                "id= " + id +
                ", name= '" + name + '\'' +
                '}';
    }
}