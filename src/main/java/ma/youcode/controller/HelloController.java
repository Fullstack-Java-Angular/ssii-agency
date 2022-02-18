package ma.youcode.controller;

import ma.youcode.dao.DaoFactory;
import ma.youcode.dao.address.IAddressDao;
import ma.youcode.domain.Address;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller()
@ResponseBody
public class HelloController {
    @RequestMapping(value = "/")
    public String welcome() {
        IAddressDao addressDao = DaoFactory.getInstance().getAddressDao();
        List<Address> list = addressDao.findAll();
        System.out.println(list);
        return "home";
    }
}
