package ma.youcode.repository;

import ma.youcode.domain.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {
    public Admin findAdminByEmail(String email);
}
