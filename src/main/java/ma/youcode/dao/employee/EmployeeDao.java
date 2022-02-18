package ma.youcode.dao.employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ma.youcode.dao.DaoFactory;
import ma.youcode.dao.DaoUtilities;
import ma.youcode.domain.Employee;

import java.util.List;

public class EmployeeDao implements IEmployeeDao {
    private DaoFactory daoFactory;

      public EmployeeDao(DaoFactory daoFactory) {
          this.daoFactory = daoFactory;      }

    @Override
    public List<Employee> findAll() {
          EntityManager em = daoFactory.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        List<Employee> employees = DaoUtilities.loadAll(Employee.class, em);
        tx.commit();
        em.close();
        return employees;
    }

    @Override
    public Employee findById(Long id) {
        EntityManager em = daoFactory.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Employee employee = em.find(Employee.class, id);
        tx.commit();
        em.close();
        return employee;
    }

    @Override
    public Employee create(Employee entity) {
        EntityManager em = daoFactory.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(entity);
        tx.commit();
        em.close();
        return entity;
    }

    @Override
    public Employee delete(Long id) {
        EntityManager em = daoFactory.getEntityManager();
        em.getTransaction().begin();
        Employee employee = em.getReference(Employee.class, id);
        em.remove(employee);
        System.out.println(em.getTransaction());
        em.getTransaction().commit();
        em.close();
        return employee;
    }

    @Override
    public Employee update(Employee entity) {
        EntityManager em = daoFactory.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Employee employee = em.merge(entity);
        tx.commit();
        em.close();
        return employee;
    }
}