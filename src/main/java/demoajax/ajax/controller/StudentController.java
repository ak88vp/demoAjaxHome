package demoajax.ajax.controller;

import demoajax.ajax.model.Category;
import demoajax.ajax.model.Student;
import demoajax.ajax.service.CategoryService;
import demoajax.ajax.service.StudentService;
import demoajax.ajax.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/students")
@CrossOrigin("*")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    CategoryService categoryService;


    @GetMapping("")
    public ResponseEntity<Iterable<Student>> findAll(){
        Iterable<Student> students=studentService.findAll();
        return new ResponseEntity<>(students,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id){
        Optional<Student> student=studentService.findById(id);
        return new ResponseEntity<>(student.get(),HttpStatus.OK);
    }
   @PostMapping("")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        studentService.save(student);
       Optional<Student> student1=studentService.findById(student.getId());
        return new ResponseEntity<>(student1.get(),HttpStatus.CREATED);
   }
   @GetMapping("category")
    public ResponseEntity<Iterable<Category>> findAllCategory(){
        Iterable<Category> categories=categoryService.findAll();
        return new ResponseEntity<>(categories,HttpStatus.OK);
   }
   @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
        studentService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
   }
   @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student student){
        student.setId(id);
        studentService.save(student);
        return new ResponseEntity<>(student,HttpStatus.OK);
   }
   @GetMapping("key/{key}")
    public ResponseEntity<Iterable<Student>> findByName(@PathVariable String key){
        Iterable<Student> students=studentService.findAllByNameContaining(key);
        return new ResponseEntity<>(students,HttpStatus.OK);
   }



}
