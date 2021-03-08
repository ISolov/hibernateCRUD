package Controllers;

import Entities.Address;
import Entities.Employee;
import Repositories.EmployeeRepository;
import Repositories.Repository;
import Repositories.implementations.AddressRepositoryimpl;
import Repositories.implementations.EmployeeRepositoryImpl;

import java.util.List;

public class AddressController {
    Repository<Address> addressRepository = new AddressRepositoryimpl();

    public Address getById(Long id){
        return addressRepository.getById(id);
    }
    public List<Address> getAll(){
        return addressRepository.getAll();
    }
    public void add(Address adr){
        addressRepository.add(adr);
    }
    public void update(Address adr){
        addressRepository.update(adr);
    }
}
