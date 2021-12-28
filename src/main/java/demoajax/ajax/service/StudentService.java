package demoajax.ajax.service;

import demoajax.ajax.model.Student;

public interface StudentService extends IGeneralService<Student> {
    Iterable<Student> findAllByNameContaining(String name);
}
