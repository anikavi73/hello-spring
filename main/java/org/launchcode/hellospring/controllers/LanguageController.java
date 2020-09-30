package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LanguageController {

    @GetMapping("langForm")
    @ResponseBody

    public String langForm(){
        return "<form method = 'post' action = 'langHello'>" +
                "<input type = 'text' name = 'name'>" +
                "<select name = 'language'>" +
                    "<option value = 'english'>English</option>" +
                    "<option value = 'dutch'>Dutch</option>" +
                    "<option value = 'ukrainian'>Ukrainian</option>" +
                    "<option value = 'latin'>Latin</option>" +
                "</select>" +
                "<input type = 'submit' value = 'Greet Me'>" +
                "</form>";
    }

    @PostMapping("langHello") //Same as form action
    @ResponseBody

    public String sayHello(@RequestParam String name, @RequestParam String language){
        return createMessage(name, language);
    }

    public static String createMessage(String name, String language){
        String result = "";

        if (language.equals("english")){
            result = "Hello, "+ name;
        } else if (language.equals("spanish")){
            result = "Hola, "+ name;
        } else if (language.equals("dutch")){
            result = "Hallo, "+ name;
        } else if (language.equals("ukrainian")){
            result = "Pryvit, "+ name;
        } else if (language.equals("latin")){
            result = "Salve, "+ name;
        }
        return result;
    }
}
