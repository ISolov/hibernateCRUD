package Repositories;

import Entities.Employee;

public interface EmployeeRepository extends Repository<Employee>{
    Employee getByFio(String fio);
}
