import JPAUtil.JPAUtil;

import javax.persistence.EntityManager;

public class Hibertest {
    public static void main(String[] args) {
        EntityManager  em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();
        JPAUtil.close();
    }
}
