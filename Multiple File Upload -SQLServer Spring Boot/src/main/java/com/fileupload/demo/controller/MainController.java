package com.fileupload.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {
    @RequestMapping("/")
    public String fileUpload(){
        return "fileTest";
    }
}
