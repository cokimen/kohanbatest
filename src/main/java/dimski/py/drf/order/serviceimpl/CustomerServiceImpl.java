package dimski.py.drf.order.serviceimpl;

import dimski.py.drf.models.Customer;
import dimski.py.drf.order.repos.CustomerJPARepo;
import dimski.py.drf.order.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service("customerServiceImpl")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerJPARepo customerRec;


    @Override
    public Customer createCustomer(Customer customer) {
        return customerRec.save(customer);
    }

    @Override
    public Customer updateCustomerById(Customer customer) {
        try {
            Optional<Customer> customerFrDB = customerRec.findById(customer.getCustomerId());
            if (customerFrDB.isPresent()) {
                return customerRec.save(customerFrDB.get());
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    @Override
    public Customer getCustomerById(UUID customerId) {
        return customerRec.findById(customerId).get();
    }

    @Override
    public Customer deleteCustomerById(UUID customerId) {
        Optional<Customer> customer = customerRec.findById(customerId);
        customer.ifPresent(x -> {
           customerRec.deleteById(x.getCustomerId());
        });
        return customer.get();

    }

    public Customer deleteCustomer(UUID customerId){
        Optional<Customer> customer = customerRec.findById(customerId);
        if (customer.isPresent()){
            customerRec.deleteById(customerId);
        }
        return customer.get();
    }

    public ArrayList<Customer> selectAllCustomer(){
        return (ArrayList<Customer>) customerRec.findAll();
    }

    public Customer selectCustomer(UUID customerId){
        return customerRec.findById(customerId).get();
    }

}
