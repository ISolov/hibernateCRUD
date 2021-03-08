package Repositories.implementations;

import Entities.Project;
import JPAUtil.JPAUtil;
import Repositories.ProjectRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepositoryImpl implements ProjectRepository {
    EntityManager em = JPAUtil.getEntityManager();

    @Override
    public Project getByName(String name) {
        Project project = null;
        try {
            em.getTransaction().begin();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Project> cq = cb.createQuery(Project.class);
            Root<Project> root = cq.from(Project.class);
            cq.select(root)
                    .where(
                            cb.equal(root.get("name"), name)
                    );
            project = em.createQuery(cq).getSingleResult();
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return project;
    }

    @Override
    public Project getById(Long id) {
        Project project = null;
        try{
            em.getTransaction().begin();
            project = em.find(Project.class, id);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        return project;
    }

    @Override
    public List<Project> getAll() {
        List<Project> projects = new ArrayList<>();
        try{
            em.getTransaction().begin();
            projects = em.createQuery("select p from Project p", Project.class)
                    .getResultList();
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
        return projects;
    }

    @Override
    public void add(Project data) {
        try{
            em.getTransaction().begin();
            em.persist(data);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Project data) {
        try {
            em.getTransaction().begin();
            em.merge(data);
            em.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
