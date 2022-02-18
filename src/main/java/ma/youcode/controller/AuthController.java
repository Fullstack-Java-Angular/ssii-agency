package ma.youcode.controller;

import ma.youcode.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthController {

    //
    @Autowired
    private AuthService authService;

    @GetMapping(value = "/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String Login(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if(!authService.login(email, password)) return "login";
        return "redirect:/employee";
    }
}
