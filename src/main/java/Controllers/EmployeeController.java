package Controllers;

import Entities.Employee;
import JPAUtil.JPAUtil;
import Repositories.EmployeeRepository;
import Repositories.implementations.EmployeeRepositoryImpl;

import java.util.List;

public class EmployeeController {
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    public Employee getById(Long id){
        return employeeRepository.getById(id);
    }
    public List<Employee> getAll(){
        return employeeRepository.getAll();
    }
    public Employee getByFio(String name){
        return employeeRepository.getByFio(name);
    }
    public void add(Employee emp){
        employeeRepository.add(emp);
    }
    public void update(Employee emp){
        employeeRepository.update(emp);
    }
}
