package ma.youcode.service;
import ma.youcode.dao.DaoFactory;
import ma.youcode.dao.employee.IEmployeeDao;
import ma.youcode.domain.Employee;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class EmployeeService implements IEmployeeService {
    private String service;

    @Override
    public Employee findEmployee(Long id) {
        IEmployeeDao employeeDao = DaoFactory.getInstance().getEmployeeDao();
        System.out.println(employeeDao.findById(id));
        return (Employee) employeeDao.findById(id);
    }
    public List<Employee> getAllEmployees() {
        IEmployeeDao employeeDao = DaoFactory.getInstance().getEmployeeDao();
        System.out.println(employeeDao.findAll());
        return employeeDao.findAll();
    }

}
