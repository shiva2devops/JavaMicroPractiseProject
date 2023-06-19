package com.shiva.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController{

        @Value("${access.firstname}")
        String firstname;
        @RequestMapping("/request/hello")
        public String requestHello() {

            return "Hello from Request mapping"+ firstname;
        }

        @GetMapping("/get")
        public String GetMapping() {

            return "get from Controller:";
        }

        @PostMapping("/post")
        public String PostMapping() {

            return "post from controller:";
        }

        @PutMapping("/put")
        public String PutMapping(){

            return "put from controller";
        }
        @DeleteMapping("/delete")
        public String DeleteMapping(){

            return "delete from controller";
        }

    }

