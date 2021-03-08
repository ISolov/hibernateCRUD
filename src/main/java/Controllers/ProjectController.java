package Controllers;

import Entities.Employee;
import Entities.Project;
import Repositories.EmployeeRepository;
import Repositories.ProjectRepository;
import Repositories.implementations.EmployeeRepositoryImpl;
import Repositories.implementations.ProjectRepositoryImpl;

import java.util.List;

public class ProjectController {
    ProjectRepository projectRepository = new ProjectRepositoryImpl();

    public Project getById(Long id){
        return projectRepository.getById(id);
    }
    public List<Project> getAll(){
        return projectRepository.getAll();
    }
    public Project getByFio(String name){
        return projectRepository.getByName(name);
    }
    public void add(Project p){
        projectRepository.add(p);
    }
    public void update(Project p){
        projectRepository.update(p);
    }
}
