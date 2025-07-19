package net.javaguides.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.entity.Student;
import net.javaguides.springboot.repository.StudentRepository;


@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "*") 
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    
    @GetMapping("/students")
   public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @DeleteMapping("/students/{id}")
public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
    studentRepository.deleteById(id);
    return ResponseEntity.ok().build();
}

@PutMapping("/students/{id}")
public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
    Optional<Student> optionalStudent = studentRepository.findById(id);
    if (!optionalStudent.isPresent()) {
        return ResponseEntity.notFound().build();
    }

    Student student = optionalStudent.get();


    student.setFname(updatedStudent.getFname());
    student.setLname(updatedStudent.getLname());
    student.setEmail(updatedStudent.getEmail());
    student.setAddress(updatedStudent.getAddress());
    student.setCity(updatedStudent.getCity());
    student.setState(updatedStudent.getState());
    student.setZip(updatedStudent.getZip());
    student.setPhone(updatedStudent.getPhone());
    student.setDate(updatedStudent.getDate());
    student.setLikedMost(updatedStudent.getLikedMost());
    student.setHowInterested(updatedStudent.getHowInterested());
    student.setHowRecommend(updatedStudent.getHowRecommend());

    studentRepository.save(student);
    return ResponseEntity.ok(student);
}

}