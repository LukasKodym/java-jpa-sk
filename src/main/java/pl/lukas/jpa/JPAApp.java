package pl.lukas.jpa;

import pl.lukas.jpa.domain.Student;
import pl.lukas.jpa.domain.University;

import javax.persistence.*;
import java.util.List;

public class JPAApp {

    static EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("lukasDB");

    static EntityManager entityManager = factory.createEntityManager();

    public static void main(String[] args) {

        createData();

        entityManager.createQuery("from University").getResultList().forEach(System.out::println);


    }

    private static void createData() {

        entityManager.getTransaction().begin();

        Student paweł = entityManager.merge(new Student("Paweł", "658942"));
        Student john = entityManager.merge(new Student("John", "987456"));

        University university = entityManager.merge(new University("UAM"));
        university.addStudent(paweł);
        university.addStudent(john);
        entityManager.merge(university);

        entityManager.getTransaction().commit();
        entityManager.clear();

    }


    private static void deleteStudent() {
        Student student = entityManager.find(Student.class, 0);
        entityManager.getTransaction().begin();
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }

    private static void updateStudent() {
        Student kinga = new Student("Kinga");
        entityManager.getTransaction().begin();
        Student student = entityManager.merge(kinga);
        student.setTelephone("125698418");
        entityManager.merge(student);
        entityManager.getTransaction().commit();
    }

    private static void readStudents() {
        Student student = entityManager.find(Student.class, 1);
        System.out.println(student);
        List fromStudent = entityManager.createQuery("from Student").getResultList();
        fromStudent.forEach(System.out::println);
    }

    private static void createStudent() {
        Student pawel = new Student("Paweł");
        entityManager.getTransaction().begin();
        entityManager.persist(pawel);
        entityManager.getTransaction().commit();
    }
}