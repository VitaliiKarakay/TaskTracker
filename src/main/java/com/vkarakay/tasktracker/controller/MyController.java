package com.vkarakay.tasktracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MyController {

    @GetMapping("/init")
    public String getInfoForAllEmps() {return "init";
    }

}
