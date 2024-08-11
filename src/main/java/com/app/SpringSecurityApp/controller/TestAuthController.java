package com.app.SpringSecurityApp.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@PreAuthorize("denyAll()") //Por defecto no vas a dejar pasar a nadie a menor que lo indiquemos
public class TestAuthController {

//    @GetMapping("/hello")
//    @PreAuthorize("permitAll()")
//    public String hello(){
//        return "Hello wordl";
//    }
//
//    @GetMapping("/hello-secured")
//    @PreAuthorize("hasAuthority('READ')")
//    public String helloSecured(){
//        return "Hello world secured";
//    }
//
//
//    @GetMapping("/hello-secured2")
//    //Este con la configuracion de arriba no dejaria pasar a nadie
//    public String helloSecured2(){
//        return "Hello world secured2";
//    }

    @GetMapping("/get")
    @PreAuthorize("hasAuthority('READ')")
    public String helloGet(){
        return "Hello-World-Get";
    }

    @GetMapping("/post")
    @PreAuthorize("hasAuthority('CREATE')")
    public String helloPost(){
        return "Hello-World-Get";
    }
    @GetMapping("/put")
    @PreAuthorize("hasAuthority('UPDATE')")
    public String helloPut(){
        return "Hello-World-Get";
    }
    @GetMapping("/delete")
    @PreAuthorize("hasAuthority('DELETE')")
    public String helloDelete(){
        return "Hello-World-Get";
    }
    @GetMapping("/patch")
    @PreAuthorize("hasAuthority('UPDATE')")
    public String helloPatch(){
        return "Hello-World-Get";
    }



}
