package ma.youcode.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ma.youcode.dao.address.AddressDao;
import ma.youcode.dao.address.IAddressDao;
import ma.youcode.dao.admin.AdminDao;
import ma.youcode.dao.admin.IAdminDao;
import ma.youcode.dao.employee.EmployeeDao;
import ma.youcode.dao.employee.IEmployeeDao;

public class DaoFactory {
    private EntityManagerFactory emf;
    private DaoFactory() {
        this.emf = Persistence.createEntityManagerFactory("hibernate-persistence-unit");
    }

    public static DaoFactory getInstance() {
        return new DaoFactory();
    }

    public EntityManager getEntityManager() {
        return this.emf.createEntityManager();
    }

    public IAddressDao getAddressDao() {
        return new AddressDao(this);
    }
    public IEmployeeDao getEmployeeDao() {
        return new EmployeeDao(this);
    }
    public IAdminDao getAdminDao() {
        return new AdminDao(this);
    }
}
