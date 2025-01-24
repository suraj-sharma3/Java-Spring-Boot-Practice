package com.example.FirstProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// A simple API
@RestController // Rest API or Controller
class ExampleAPI {
    @GetMapping("app name") // API name
    String printName(){
        return "Random Web App";
    }
}
