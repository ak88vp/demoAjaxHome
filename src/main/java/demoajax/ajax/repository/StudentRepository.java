package demoajax.ajax.repository;

import demoajax.ajax.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Iterable<Student> findAllByNameContaining(String name);
}
