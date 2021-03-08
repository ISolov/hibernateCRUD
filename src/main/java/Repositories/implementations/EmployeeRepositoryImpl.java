package Repositories.implementations;

import Entities.Employee;
import JPAUtil.JPAUtil;
import Repositories.EmployeeRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.transaction.Transaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    EntityManager em = JPAUtil.getEntityManager();

    @Override
    public Employee getByFio(String fio) {
        Employee emp = null;
        try {
            em.getTransaction().begin();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
            Root<Employee> root = cq.from(Employee.class);
            cq.select(root)
                    .where(
                            cb.equal(root.get("FIO"), fio)
                    );
            TypedQuery<Employee> tq = em.createQuery(cq);
            emp = tq.getSingleResult();
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
        return emp;
    }

    @Override
    public Employee getById(Long id) {
        Employee employee = null;
        try{
            em.getTransaction().begin();
            employee = em.find(Employee.class, id);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        try{
            em.getTransaction().begin();
            employees = em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void add(Employee data) {
        try{
            em.getTransaction().begin();
            em.persist(data);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Employee data) {
        try{
            em.getTransaction().begin();
            em.merge(data);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
