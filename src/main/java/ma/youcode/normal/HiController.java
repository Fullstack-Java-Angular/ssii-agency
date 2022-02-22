package ma.youcode.normal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class HiController {

    @GetMapping("")
    public String greeting() {
        return "Hi from normal web application";
    }
}
