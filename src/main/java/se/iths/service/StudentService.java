package se.iths.service;

import se.iths.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    public void create(Student student) {
        entityManager.persist(student);
    }

    public void update(Student student, Long id) {
        if (!Objects.equals(student.getId(), id))
            throw new IllegalStateException("Provided student IDs do not match");
        entityManager.merge(student);
    }

    public List<Student> getByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s WHERE s.lastName LIKE :lastName", Student.class);
        query.setParameter("lastName", "%" + lastName + "%");
        return query.getResultList();
    }

    public void delete(Long id) {
        Student foundStudent = entityManager.find(Student.class, id);
        entityManager.remove(foundStudent);
    }

    public List<Student> getAll() {
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    public Student getById(Long id) {
        return Optional.ofNullable(entityManager.find(Student.class, id))
                .orElseThrow(() -> new NotFoundException("Could not find entity with id: " + id));
    }
}
