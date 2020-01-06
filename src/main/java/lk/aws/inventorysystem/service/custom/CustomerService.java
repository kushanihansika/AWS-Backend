package lk.aws.inventorysystem.service.custom;

import lk.aws.inventorysystem.dto.CustomerDTO;
import lk.aws.inventorysystem.service.SuperService;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService extends SuperService {

    Page<CustomerDTO> getCustomersPage(int page, int size);

    List<CustomerDTO> getAllCustomers();

    String saveCustomer(CustomerDTO dto);

    void updateCustomer(CustomerDTO dto);

    void removeCustomer(String id);

    CustomerDTO getCustomerById(String id);

    boolean isCustomerExists(String id);

    long customersCount();

}
