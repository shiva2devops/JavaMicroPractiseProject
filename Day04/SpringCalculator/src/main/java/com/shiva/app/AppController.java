package com.shiva.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {

    @GetMapping("/add")
    public double add(@RequestParam("a") double a,@RequestParam("b") double b){
        return a+b;
    }
    @GetMapping("/mul")
    public double mul(@RequestParam("a") double a,@RequestParam("b") double b){
        return a*b;
    }

    @GetMapping("/sub")
    public double sub(@RequestParam("a") double a,@RequestParam("b") double b){
        return a-b;
    }

    @GetMapping("/div")
    public double div(@RequestParam("a") double a,@RequestParam("b") double b){
        return a/b;
    }
}
