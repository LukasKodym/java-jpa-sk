package pl.lukas.jpa;

import pl.lukas.jpa.domain.Student;
import pl.lukas.jpa.domain.University;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JPAApp {

    static EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("lukasDB");

    static EntityManager entityManager = factory.createEntityManager();

    public static void main(String[] args) {

        entityManager.getTransaction().begin();

        Student paweł = entityManager.merge(new Student( "Paweł", "658942"));
        Student merge = entityManager.merge(paweł);
        entityManager.getTransaction().commit();

        System.out.println(paweł);
        System.out.println(paweł.getIndeks());

        entityManager.getTransaction().begin();
        University pp = entityManager.merge(new University("PP"));
        pp.addStudent(paweł);
        entityManager.getTransaction().commit();


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