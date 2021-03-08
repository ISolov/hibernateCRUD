package Repositories.implementations;

import Entities.Address;
import Entities.Project;
import JPAUtil.JPAUtil;
import Repositories.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class AddressRepositoryimpl implements Repository<Address> {
    EntityManager em = JPAUtil.getEntityManager();

    @Override
    public Address getById(Long id) {
        Address address = null;
        try {
            em.getTransaction().begin();
            address = em.find(Address.class, id);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public List<Address> getAll() {
        List<Address> addresses = new ArrayList<>();
        try{
            em.getTransaction().begin();
            addresses = em.createQuery("select a from Address a", Address.class).getResultList();
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
        return addresses;
    }

    @Override
    public void add(Address data) {
        try{
            em.getTransaction().begin();
            em.persist(data);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Address data) {
        try{
            em.getTransaction().begin();
            em.merge(data);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
