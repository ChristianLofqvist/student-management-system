package se.iths.service;

import se.iths.entity.Subject;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Validator;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Transactional
public class SubjectService {

    @PersistenceContext
    EntityManager entityManager;

    @Inject
    Validator validator;

    public void create(Subject subject) {
        entityManager.persist(subject);
    }

    public Subject update(Subject subject, Long id) {
        validateSubject(subject);
        if (!Objects.equals(subject.getId(), id)) {
            throw new IllegalStateException("ID did not match given ID");
        }
        return entityManager.merge(getById(subject.getId()));
    }

    private void validateSubject(Subject subject) {
        var validations = validator.validate(subject);
        if (validations.size() > 0)
            throw new BadRequestException("Invalid subject");
    }

    public void delete(Long id) {
        getById(id);
        Subject foundSubject = entityManager.find(Subject.class, id);
        entityManager.remove(foundSubject);
    }

    public List<Subject> getAll() {
        return entityManager.createQuery("SELECT s FROM Subject s", Subject.class)
                .getResultList();
    }

    public Subject getById(Long id) {
        return Optional.ofNullable(entityManager.find(Subject.class, id))
                .orElseThrow(() -> new NotFoundException("Could not find entity with ID: " + id));
    }

    public Subject patch(Subject subject, Long id) {
        Subject oldSubject = getById(id);

        if (subject.getName() != null)
            oldSubject.setName(subject.getName());

        return oldSubject;
    }
}
