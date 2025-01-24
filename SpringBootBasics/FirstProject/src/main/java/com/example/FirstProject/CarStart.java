package com.example.FirstProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarStart {

    public Car car = new Car();

    @GetMapping("/start")
    public  String start(){
        return car.start();
    }

}
