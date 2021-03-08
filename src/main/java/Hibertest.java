import Controllers.AddressController;
import Controllers.DepartmentController;
import Controllers.EmployeeController;
import Controllers.ProjectController;
import Entities.Address;
import Entities.Department;
import Entities.Employee;
import Entities.Project;
import JPAUtil.JPAUtil;

import javax.persistence.EntityManager;

public class Hibertest {
    public static void main(String[] args) {
        DepartmentController departmentController = new DepartmentController();
        ProjectController projectController = new ProjectController();
        AddressController addressController = new AddressController();
        EmployeeController employeeController = new EmployeeController();
//        Department department = new Department();
//        department.setAddress("Mohovaya street");
//        departmentController.add(department);
//
//
//
//        Project project = new Project();
//        project.setName("Main Project");
//        projectController.add(project);
//
//
//
//        Address address = new Address();
//        address.setAddress("Tverskaya street, 21");
//        addressController.add(address);
//
//        Employee employee = new Employee();
//        employee.setDepartment(department);
//        employee.addProject(project);
//        employee.setAddress(address);
//        employee.setFIO("Ivanov");
//        employeeController.add(employee);
//        Employee employee2 = new Employee();
//        employee2.setDepartment(department);
//        employee2.addProject(project);
//        employee2.setAddress(address);
//        employee2.setFIO("Sidorov");
//        employeeController.add(employee2);
        Employee emp = employeeController.getByFio("Ivanov");
        System.out.println(emp);
        Employee emp2 = employeeController.getById(5L);
        System.out.println(emp2);
        Address add = addressController.getById(3L);
        System.out.println(add);
        Department dep = departmentController.getById(1L);
        System.out.println(dep);
        Project pro = projectController.getById(2L);
        System.out.println(pro);
        JPAUtil.close();

    }
}
