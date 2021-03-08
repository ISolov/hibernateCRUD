package Repositories;

import Entities.Project;

public interface ProjectRepository extends Repository<Project>{
    Project getByName(String name);
}
