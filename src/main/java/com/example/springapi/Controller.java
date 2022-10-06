package com.example.springapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    private final StudentService studentService;

    public Controller(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("list")
    public List<Stundent> list() {
        return studentService.list();
    }

    @PostMapping("item")
    public List<Stundent> add(@RequestBody Stundent stundent) {
        studentService.save(stundent);
        return studentService.list();
    }

    @DeleteMapping("item/{studentId}")
    public void delete(@PathVariable Long studentId){
        studentService.delete(studentId);
    }

    @PutMapping("item")
    public void update(@RequestBody Stundent stundent){
        studentService.update(stundent);
    }
}
