package dimski.py.drf.order.rest;


import dimski.py.drf.order.dto.OrderRequest;
import dimski.py.drf.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/order")
public class OrderRoute {

    @Autowired @Qualifier("OrderServiceImpl")
    OrderService orderService;

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<Object> createOrder(@RequestBody OrderRequest orderRequest){
        orderService.createOrder(orderRequest);
        return ResponseEntity.status(200).body("oke");
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<Object> getOrders(@RequestBody OrderRequest orderRequest){
        return ResponseEntity.status(200).body("oke");
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getOrder(@PathVariable("id") UUID orderId){
        return ResponseEntity.status(200).body("oke");
    }


    @RequestMapping( path = "/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Object> updateOrder(@PathVariable("id") UUID orderId){
        return ResponseEntity.status(200).body("oke");
    }


}
