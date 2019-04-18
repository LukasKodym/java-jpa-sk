package pl.lukas.jpa;

import pl.lukas.jpa.domain.Student;

import javax.persistence.*;
import java.util.List;

public class JPAApp {

    static EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("lukasDB");

    static EntityManager entityManager = factory.createEntityManager();

    public static void main(String[] args) {

        createData();

        TypedQuery<QueryResult> query = entityManager
                .createQuery("select new pl.lukas.jpa.QueryResult(s.name, s.indeks.number) " +
                        "from Student s where s.name in ('Paweł','John')", QueryResult.class);

//        query.getResultList().forEach(System.out::println);
        List<CountResult> resultList = entityManager
                .createQuery("select new pl.lukas.jpa.CountResult(s.name, count(s)) " +
                        "from Student s group by s.name " +
                        "having s.name like 'P%'", CountResult.class).getResultList();

        resultList.forEach(System.out::println);

        entityManager.createNamedQuery("Student.getAll", Student.class)
                .getResultList().forEach(System.out::println);
        entityManager.createNamedQuery("Student.byName", Student.class)
                .setParameter("name", "John")
                .getResultList().forEach(System.out::println);

    }

    private static void createData() {

        entityManager.getTransaction().begin();

        entityManager.merge(new Student("Paweł", "658942"));
        entityManager.merge(new Student("Paweł", "658953"));
        entityManager.merge(new Student("Paweł", "658964"));
        entityManager.merge(new Student("John", "987456"));

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