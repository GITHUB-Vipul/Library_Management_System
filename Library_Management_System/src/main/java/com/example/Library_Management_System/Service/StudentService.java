package com.example.Library_Management_System.Service;

import com.example.Library_Management_System.Enum.CardStatus;
import com.example.Library_Management_System.Repository.StudentRepository;
import com.example.Library_Management_System.model.LibraryCard;
import com.example.Library_Management_System.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student) {
        LibraryCard libraryCard=new LibraryCard();
        libraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
        libraryCard.setCardStatus(CardStatus.ACTIVE);
        libraryCard.setStudent(student);
        student.setLibraryCard(libraryCard);
         studentRepository.save(student);
        return "Student has been added successfully";
    }

    public Student getStudent(int regNo) {
        Optional<Student> studentOptional=studentRepository.findById(regNo);
        return studentOptional.orElse(null);
    }

    public void  deleteStudent(int regNo) {
         studentRepository.deleteById(regNo);

    }
}
