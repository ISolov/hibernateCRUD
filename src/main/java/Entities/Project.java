package Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue
    private Long id;

    @Column()
    private String name;

    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees = new ArrayList<>();


//    public void addEmployee(Employee employee){
//        this.employees.add(employee);
//        employee.getProjects().add(this);
//    }
//    public void removeEmployee(Employee employee){
//        this.employees.remove(employee);
//        employee.getProjects().remove(this);
//    }

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
