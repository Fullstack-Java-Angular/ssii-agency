package ma.youcode.repository;

import ma.youcode.domain.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Long> {
    public Admin findAdminByEmail(String email);
}
