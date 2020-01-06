package lk.aws.inventorysystem.service.custom.impl;

import lk.aws.inventorysystem.repository.CustomerRepository;
import lk.aws.inventorysystem.dto.CustomerDTO;
import lk.aws.inventorysystem.entity.Customer;
import lk.aws.inventorysystem.service.custom.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

//    public CustomerServiceImpl(){
//        String repository = DAOFactory.getInstance().<String>getDAO(DAOTypes.CUSTOMER);
//    }

    @Override
    public CustomerDTO getCustomerById(String id) {
        Customer customer = customerRepository.getOne(id);
        CustomerDTO customerDTO = new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress());
        return customerDTO;

    }

    @Override
    public boolean isCustomerExists(String id) {
        return customerRepository.existsById(id);
    }

    @Override
    public long customersCount() {
        return customerRepository.count();
    }

    @Override
    public Page<CustomerDTO> getCustomersPage(int page, int size) {
        return customerRepository.findAll(PageRequest.of(page, size))
                .map(c -> new CustomerDTO(c.getId(), c.getName(), c.getAddress()));
    }

    public List<CustomerDTO> getAllCustomers()  {
        List<CustomerDTO> customers = customerRepository.findAll().stream().map(customer -> new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress())).collect(Collectors.toList());
        return customers;

    }

    public String saveCustomer(CustomerDTO dto)   {
        if (customerRepository.existsById(dto.getId())){
            throw new RuntimeException("Customer already exists");
        }
        return customerRepository.save(new Customer(dto.getId(), dto.getName(), dto.getAddress())).getId();
    }

    public void updateCustomer(CustomerDTO dto)   {
        customerRepository.save(new Customer(dto.getId(), dto.getName(), dto.getAddress()));
    }

    public void removeCustomer(String id)   {
        customerRepository.deleteById(id);
    }

}
