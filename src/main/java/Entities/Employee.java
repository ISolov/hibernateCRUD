package Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    private String FIO;

    @ManyToOne
    private Department department;

    @ManyToMany( cascade = {CascadeType.MERGE})
    @JoinTable(name="employee_project",
            joinColumns = {@JoinColumn(name="employee_id")},
            inverseJoinColumns = {@JoinColumn(name="project_id")}
    )
    private List<Project> projects = new ArrayList<>();

    public Employee() {
    }

    public void addProject(Project project){
        this.projects.add(project);
        project.getEmployees().add(this);
    }

    public void removeProject(Project project){
        this.projects.remove(project);
        project.getEmployees().remove(this);
    }

    public void setDepartment(Department department) {
        this.department = department;
        department.getEmployees().add(this);
    }

    public void removeDepartment(Department department){
        this.department = null;
        department.getEmployees().remove(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public Department getDepartment() {
        return department;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", address=" + address.getAddress() +
                ", FIO='" + FIO + '\'' +
                ", department=" + department.getAddress() +
                ", projects=" + projects.get(0).getName() +
                '}';
    }
}
