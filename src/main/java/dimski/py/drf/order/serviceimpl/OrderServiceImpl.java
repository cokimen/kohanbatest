package dimski.py.drf.order.serviceimpl;

import dimski.py.drf.models.Customer;
import dimski.py.drf.models.Order;
import dimski.py.drf.models.Product;
import dimski.py.drf.order.dto.OrderRequest;
import dimski.py.drf.order.repos.CustomerJPARepo;
import dimski.py.drf.order.repos.OrderJPARepo;
import dimski.py.drf.order.repos.ProductJPARepo;
import dimski.py.drf.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.UUID;

@Service("OrderServiceImpl")
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderJPARepo orderJPARepo;

    @Autowired
    CustomerJPARepo customerJPARepo;

    @Autowired
    ProductJPARepo productJPARepo;

    @Override
    public Order createOrder(@RequestBody OrderRequest orderRequest) {

        Optional<Product> product = productJPARepo.findById(UUID.fromString(orderRequest.getProduct()));
        System.out.println(product.get().getId());
        Optional<Customer> customer = customerJPARepo.findById(UUID.fromString(orderRequest.getCustomer()));
        Order order = new Order();
        order.setProduct(product.get());
        order.setQuantity(orderRequest.getQuantity());
        order.setAmount( Double.valueOf(product.get().getProductPrice()) * Double.valueOf(orderRequest.getQuantity()) );
        order.setCustomer(customer.get());
        if (product.isPresent() && product.get().getStock() >= orderRequest.getQuantity()){
            product.get().setStock( product.get().getStock() - orderRequest.getQuantity() );
            productJPARepo.save(product.get());
            order = orderJPARepo.save(order);
        }
        return order;
    }
}
