package it.unito.jpasession.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks/username")
public class UserController {
    @PostMapping
    public void setUser(@RequestParam String username, HttpSession session) {
        session.setAttribute("username", username);
    }

    @GetMapping
    public String getUser(HttpSession session) {
        Object username = session.getAttribute("username");
        return username != null ? username.toString() : "Anonimo";
    }
}
