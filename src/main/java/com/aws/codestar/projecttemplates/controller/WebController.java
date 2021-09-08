package com.aws.codestar.projecttemplates.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

//    @CrossOrigin // TODO: This doesn't seem to do anything - need to rely on manual CORS header injection below
    @RequestMapping("/")
    @ResponseBody
    public ResponseEntity<String> home() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        return ResponseEntity.ok()
//                .headers(responseHeaders)
                .body("{\"Output\":\"Welcome home!\"}");
    }

//    @CrossOrigin // TODO: This doesn't seem to do anything - need to rely on manual CORS header injection below
    @PreAuthorize("hasAuthority('admins')")
    @RequestMapping("/restricted")
    @ResponseBody
    public ResponseEntity<String> restricted() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        return ResponseEntity.ok()
//                .headers(responseHeaders)
                .body("{\"Output\":\"You found the secret lair!\"}");
    }

}
