package pl.lukas.jpa;

import pl.lukas.jpa.domain.Indeks;
import pl.lukas.jpa.domain.Student;
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

        Student paweł = entityManager.merge(new Student( "Paweł"));
        Indeks indeks = entityManager.merge(new Indeks( "132456"));
        System.out.println(paweł);
        paweł.setIndeks(indeks);

        paweł = entityManager.merge(paweł);
        indeks.setOwner(paweł);
        entityManager.merge(indeks);
        entityManager.getTransaction().commit();

        System.out.println(paweł);

        Indeks idx = entityManager.find(Indeks.class, indeks.getId());
        System.out.println(idx);




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