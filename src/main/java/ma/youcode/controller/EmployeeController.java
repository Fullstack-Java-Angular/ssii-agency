package ma.youcode.controller;

import ma.youcode.domain.Address;
import ma.youcode.domain.Employee;
import ma.youcode.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public String index(ModelMap model) {
        List<Employee> employees = employeeService.listAll();
        System.out.println("employees = " + employees);
        model.addAttribute("employees", employees);
        // TODO: check emoployees list have at least one employee
        return "dashboard";
    }

//    @GetMapping("/employee/create")
//    public String create() {
//        return "/employee/create";
//    }

    @PostMapping("/employee")
    public String store(HttpServletRequest request) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String addressLine = request.getParameter("address");
        Employee employee = new Employee();
        Address address = new Address();
        address.setLine(addressLine);
        employee.setAddress(address);
        employee.setEmail(email);
        employee.setName(name);
        employee.setPhone(phone);

        employeeService.save(employee);
        return "redirect:/employee";
    }

//    @GetMapping("/employee/{id}")
//    public String show(@PathVariable String id) {
//        return "/employee/" + id;
//    }

//    @GetMapping("/employee/{id}/edit")
//    public String edit(@PathVariable String id) {
//        return "/employee/"+ id +"/edit";
//    }

    @PostMapping("/employee/delete")
    public String update(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        employeeService.delete(id);
        return "redirect:/employee";
    }

    // TODO: Update
    @PostMapping("/employee/update")
    public String destroy(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String addressLine = request.getParameter("address");
        Employee employee = employeeService.get(id);
        employee.getAddress().setLine(addressLine);
        employee.setEmail(email);
        employee.setName(name);
        employee.setPhone(phone);
        employeeService.save(employee);
        return "redirect:/employee";
    }
}
