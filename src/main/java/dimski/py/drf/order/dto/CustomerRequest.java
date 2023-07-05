package dimski.py.drf.order.dto;

import dimski.py.drf.models.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class CustomerRequest implements Serializable {
    private String customerName;

    private String address;

    private String phone;

    public Customer createCustomer(){
        Customer customer = new Customer();
        customer.setCustomerName(customerName);
        customer.setAddress(address);
        customer.setPhone(phone);
        return customer;
    }
}
