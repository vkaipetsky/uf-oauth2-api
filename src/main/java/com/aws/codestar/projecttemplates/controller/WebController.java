package com.aws.codestar.projecttemplates.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

    @CrossOrigin(origins = "*")
    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Welcome home!";
    }

    @CrossOrigin(origins = "*")
    @PreAuthorize("hasAuthority('admins')")
    @RequestMapping("/restricted")
    @ResponseBody
    public String restricted() {
        return "You found the secret lair!";
    }

}
