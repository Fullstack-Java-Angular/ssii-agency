//package ma.youcode.controller;
//
//import ma.youcode.repository.address.AddressDao;
//import ma.youcode.domain.Address;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//
//@Controller
//@ResponseBody
//public class HelloController {
//
//    @Autowired
//    private AddressDao addressDao;
//
//    @RequestMapping(value = "/")
//    public String welcome() {
//        List<Address> list = addressDao.findAll();
//        System.out.println(list);
//        return "dashboard";
//    }
//}
