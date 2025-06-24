package com.example.student.studentcontroller;

import org.springframework.web.bind.annotation.RestController;

import com.example.student.Repository.Studendrepository;
import com.example.student.particular.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;



@RestController
@RequestMapping("/students") 
public class Studentcontroller {
    // creates student endpoint
    // @GetMapping("/student")
    @Autowired
    Studendrepository repos;
    //localhost:8080/students
    // This method handles GET requests to the "/students" endpoint.
        @GetMapping
    public List<Student>getAllstudents(){
        // This method retrieves all students from the database.
        // It uses the Studendrepository to fetch the data. he have created an object of the repository
        List<Student> students = repos.findAll();    
        return students; }



        @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){
        Student student= repos.findById(id).get();
        return student;
    }
        //create a student

    // @GetMapping("/students/add")
    // public void createStudent(@RequestParam int rollNo, @RequestParam String name, @RequestParam float percentage, @RequestParam String branch) {
    //     // This method creates a new student with the provided parameters.
    //     Student student = new Student();
    //     student.setRollNo(rollNo);
    //     student.setName(name);
    //     student.setPercentage(percentage);
    //     student.setBranch(branch);
    //     repos.save(student); // Save the new student to the database
    // }
    @PostMapping("/add")
    @ResponseStatus(code=HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student) {
      repos.save(student); // Save the new student to the database
      
    }
    // Update 
    @PutMapping("/update/{id}")
    public void updateStudent(@PathVariable int id,String name,float percentage,String branch){
        Student student= repos.findById(id).get();
        student.setName(name);
        student.setPercentage(percentage);
        student.setBranch(branch);
        repos.save(student);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable int id){
        repos.deleteById(id);
    }

}
