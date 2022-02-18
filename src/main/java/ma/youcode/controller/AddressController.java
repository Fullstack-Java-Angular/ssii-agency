package ma.youcode.controller;

import ma.youcode.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/address")
    @ResponseBody
    public String index() {
        System.out.println(addressService.listAll());
        System.out.println("hello");
        return "Addresss";
    }
}
