package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Controller
//public class HelloController {
//
//    @GetMapping //responds to get requests
//    @ResponseBody // will return plain text response
//
//    public String hello(){
//        return "Hello, Spring!";
//    }
//}

@Controller
//@ResponseBody //add here for all the method handlers
@RequestMapping("hello") // every method should begin with hello route

public class HelloController {

//    @GetMapping("hello") //responds to get requests
//    @ResponseBody // will return plain text response
//
//    public String hello(){
//        return "Hello, Spring!";
//    }

    //route is now /hello/goodbye
    @GetMapping("goodbye") //responds to get requests
    @ResponseBody // will return plain text response

    public String goodbye(){ return "GoodBye, Spring!"; }

    //Handles request with query parameter of the form /hello?name=LaunchCode
    //dynamic data http://localhost:8080/hello?name=Kavitha will show Hello, Kavitha!

    //@GetMapping("hello")
    //Request Mapping can be used for both Get and Post requests
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")

    //now lives in /hello/name
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
//    @ResponseBody
//    public String helloWithQueryParam(@RequestParam String name){
//        return "Hello, " + name + "!";
//    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
//    @ResponseBody // not required = using template
//      localhost:8080/hello/form or localhost:8080/hello/hello?name=LaunchCode
    public String helloWithQueryParam(@RequestParam String name, Model model){
        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", theGreeting);
        return "hello"; // looks for template file
    }

    //handler that handles requests of the form /hello/LaunchCode
    //Path parameter for dynamic request

//    @GetMapping("hello/{name}")
    @GetMapping("{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    //Using form data
//    @GetMapping("form")
//    @ResponseBody  // request is sent through query parameters
//    public String helloForm(){
//        return "<html>" +
//                "<body>" +
//                "<form action = 'hello'>" + //submit a request to /hello
//                "<input type = 'text' name='name'>" +
//                "<input type = 'submit' value = 'Great me!'>" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//    }

    //Using form data with Post request
    //now lives in /hello/form

    @GetMapping("form")
//    @ResponseBody // no response body means look for template
    public String helloForm(){
        return "form";


//        return  "<html>" +
//                "<body>" +
//                "<form action = 'hello' method = 'post'>" + //submit a request to /hello
//                "<input type = 'text' name='name'>" +
//                "<input type = 'submit' value = 'Great me!'>" +
//                "</form>" +
//                "</body>" +
//                "</html>";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){

        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");

        model.addAttribute("names", names);

        return "hello-list";
    }

}


