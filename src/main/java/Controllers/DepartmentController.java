package Controllers;

import Entities.Address;
import Entities.Department;
import Repositories.Repository;
import Repositories.implementations.AddressRepositoryimpl;
import Repositories.implementations.DepartmentRepositoryImpl;

import java.util.List;

public class DepartmentController {
    Repository<Department> departmentRepository = new DepartmentRepositoryImpl();

    public Department getById(Long id){
        return departmentRepository.getById(id);
    }
    public List<Department> getAll(){
        return departmentRepository.getAll();
    }
    public void add(Department dep){
        departmentRepository.add(dep);
    }
    public void update(Department dep){
        departmentRepository.update(dep);
    }
}
