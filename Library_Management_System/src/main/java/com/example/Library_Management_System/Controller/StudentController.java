package com.example.Library_Management_System.Controller;

import com.example.Library_Management_System.Service.StudentService;
import com.example.Library_Management_System.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student)
    {
       String response=studentService.addStudent(student);
       return new ResponseEntity(response, HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity getStudent(@RequestParam int regNo)
    {
        Student student= studentService.getStudent(regNo);
        if(student!=null)
        {
            return new ResponseEntity(student,HttpStatus.FOUND);
        }
        return new ResponseEntity("Invalid Id",HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/deleteStudent")
    public String deleteStudent(@RequestParam int regNo)
    {
        studentService.deleteStudent(regNo);

        return "Student has been deleted successfully";
    }



}
