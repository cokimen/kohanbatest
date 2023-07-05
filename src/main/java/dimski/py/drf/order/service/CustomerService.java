package dimski.py.drf.order.service;

import dimski.py.drf.models.Customer;
import org.springframework.stereotype.Service;

import java.util.UUID;



public interface CustomerService {
    public Customer createCustomer(Customer customer);
    public Customer updateCustomerById(Customer customer);

    public Customer getCustomerById(UUID customerId);

    public Customer deleteCustomerById(UUID customerId);

}
