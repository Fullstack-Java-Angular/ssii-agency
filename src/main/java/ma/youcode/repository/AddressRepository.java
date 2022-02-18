package ma.youcode.repository;


import ma.youcode.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> { }
