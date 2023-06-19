package com.shiva.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    StudentOperation studentOperation;

    @PostMapping("/create/studentData")
    public StudentData CreateStudentData(@RequestBody StudentData StudentData){
        return StudentData;
    }

    @GetMapping("/get/studentData")
    public String getStudentData(@RequestParam("name") String name,@RequestParam("role") String role,@RequestParam("schoolname") String schoolname,@RequestParam("age") String age ){

        return "Student data is :"+ name + "role number :" + role + "SchoolName :" + schoolname + " age :" + age;
    }

    @GetMapping("/get/append")
    public String appendData(@RequestParam("name") String name, @RequestParam("age") String age){
        return studentOperation.addString(name, age);
    }

    @GetMapping("/get/findPrime")
    public List<Integer> findprime(@RequestParam("count") int count){
        return studentOperation.findprime(count);
    }


}

