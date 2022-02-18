package ma.youcode.service;

import ma.youcode.domain.Admin;
import ma.youcode.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AdminRepository repository;

    public Boolean login(String email, String password) {
        Admin admin = repository.findAdminByEmail(email);
        if(admin == null) return false;
        return admin.getEmail().equalsIgnoreCase(email) && admin.getPassword().equals(password);
    }
}
