package com.stark.rest.webservices.restfulwebservices.helloworld.controller;

import com.stark.rest.webservices.restfulwebservices.helloworld.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

//RESTAPI
@RestController
public class HelloWorldController {

    //hello-world

    //@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    @GetMapping("/hello-world") //better way, much more readable
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/hello-world-bean") //better way, much more readable
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World from a Bean");
    }

    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    @GetMapping("/hello-world-nations/{nation}")
    public String helloWorldBeanNations(@PathVariable String nation){
        String en = "Good Morning";
        String es = "Buenos dias";
        String fr = "Bonjour";
        String salute = "";

        if (nation.equals("en")){
            salute = en;
        } else if (nation.equals("fr")) {
            salute = fr;
        } else if (nation.equals("es")) {
            salute = es;
        }

        return salute;
    }

}
