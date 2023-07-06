package dimski.py.drf.order.service;

import dimski.py.drf.models.Order;
import dimski.py.drf.order.dto.OrderRequest;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.UUID;

public interface OrderService {
    public Order createOrder(@RequestBody OrderRequest orderRequest);
    public ArrayList<Order> getOrders();

    public Order getOrder(UUID orderId);

    public Order updateOrder(Order order);
}
