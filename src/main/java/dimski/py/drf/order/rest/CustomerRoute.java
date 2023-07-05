package dimski.py.drf.order.rest;


import dimski.py.drf.models.Customer;
import dimski.py.drf.models.Order;
import dimski.py.drf.models.Product;
import dimski.py.drf.order.dto.CustomerRequest;
import dimski.py.drf.order.dto.ResponseStd;
import dimski.py.drf.order.repos.ProductJPARepo;
import dimski.py.drf.order.service.CustomerService;
import dimski.py.drf.order.service.ProductService;
import dimski.py.drf.order.serviceimpl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerRoute {

    @Autowired

    CustomerServiceImpl customerService;


    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<Object> createCustomer(@RequestBody CustomerRequest customerRequest){
        System.out.println(customerRequest.toString());
        ResponseStd response = ResponseStd.genResponse(200, customerService.createCustomer(customerRequest.createCustomer()));
        return ResponseEntity.status(200).body(response.getBodyJson());
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<Object> getCustomers(){
        return ResponseEntity.status(200).body(
                ResponseStd.genResponse(200, customerService.selectAllCustomer()).getBodyJson()
        );
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getCustomer(@PathVariable("id") UUID customerId){
        Optional<Customer> customer = Optional.ofNullable(customerService.getCustomerById(customerId));
        return ResponseEntity.status(200).body(
                ResponseStd.genResponse(200, customer.get()).getBodyJson()
        );
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") UUID customerId, @RequestBody CustomerRequest customerRequest){
        Customer customer = customerRequest.createCustomer();
        customer.setCustomerId(customerId);
        System.out.println(customer.getCustomerName());
        customerService.updateCustomerById(customer);
        return ResponseEntity.status(200).body(
                ResponseStd.genResponse(200, customer).getBodyJson()
        );
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> removeCustomer(@PathVariable("id") UUID customerId){
        Customer customer = customerService.deleteCustomer(customerId);
        return ResponseEntity.status(200).body(
                ResponseStd.genResponse(200, customer).getBodyJson()
        );
    }
}
