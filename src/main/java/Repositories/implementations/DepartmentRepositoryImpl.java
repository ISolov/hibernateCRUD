package Repositories.implementations;

import Entities.Department;
import JPAUtil.JPAUtil;
import Repositories.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepositoryImpl implements Repository<Department> {
    EntityManager em = JPAUtil.getEntityManager();

    @Override
    public Department getById(Long id) {
        Department department = null;
        try {
            em.getTransaction().begin();
            department = em.find(Department.class, id);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
        return department;
    }

    @Override
    public List<Department> getAll() {
        List<Department> deps = new ArrayList<>();
        try {
            em.getTransaction().begin();
            deps = em.createQuery("select d from Department d", Department.class).getResultList();
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
        return deps;
    }

    @Override
    public void add(Department data) {
        try {
            em.getTransaction().begin();
            em.persist(data);
            em.getTransaction().commit();
        }catch(RuntimeException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Department data) {
        try {
            em.getTransaction().begin();
            em.merge(data);
            em.getTransaction().commit();
        }catch(RuntimeException e){
            e.printStackTrace();
        }
    }
}
