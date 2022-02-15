package ma.youcode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
@ResponseBody
public class HelloController {
    @RequestMapping(value = "/")
    public String welcome() {
        System.out.println("hello##############################################");
        return "home";
    }
}
