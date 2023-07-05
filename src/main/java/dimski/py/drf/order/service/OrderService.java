package dimski.py.drf.order.service;

import dimski.py.drf.models.Order;
import dimski.py.drf.order.dto.OrderRequest;
import org.springframework.web.bind.annotation.RequestBody;

public interface OrderService {
    public Order createOrder(@RequestBody OrderRequest orderRequest);
}
