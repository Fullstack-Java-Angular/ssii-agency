package ma.youcode.service;

import ma.youcode.domain.Address;
import ma.youcode.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AddressService {
    @Autowired
    private AddressRepository repository;

    public void save(Address address) {
        repository.save(address);
    }

    public List<Address> listAll() {
        return (List<Address>) repository.findAll();
    }

    public Address get(Long id) {
        return repository.findById(id).get();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
