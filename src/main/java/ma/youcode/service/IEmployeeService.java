package ma.youcode.service;


import ma.youcode.domain.Employee;

public interface IEmployeeService {
    public abstract Employee findEmployee(Long id);
}
