package com.example.springapi;

import com.example.springapi.response.RestApiException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Stundent> list() {
        return studentRepository.findAll();
    }

    public void save(Stundent stundent) {
        if(studentRepository.findByEmail(stundent.getEmail()).isPresent()){
            throw new RestApiException("Email is busy");
        }
        studentRepository.save(stundent);
    }

    public void delete(Long studentId) {
        studentRepository.deleteById(studentId);
    }


    public void update(Stundent stundent) {
        Optional<Stundent> studentOptional = studentRepository.findById(stundent.getId());

        if(studentOptional.isPresent()) {
            Stundent updatedStudent = studentOptional.get();
            if(!stundent.getName().isEmpty()){
                updatedStudent.setName(stundent.getName());
            }
            if(stundent.getDob() != null){
                updatedStudent.setDob(stundent.getDob());
            }
            studentRepository.save(updatedStudent);
        }
    }
}
