package ma.youcode.dao.admin;


import ma.youcode.dao.IDao;
import ma.youcode.domain.Admin;

public interface IAdminDao extends IDao<Admin> {
    public abstract Object findByEmail(String email);
}
