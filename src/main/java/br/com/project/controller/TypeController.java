package br.com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TypeController {

    @RequestMapping("/type")
    public String typeRouter(Model model){
        return "type";
    }

}
