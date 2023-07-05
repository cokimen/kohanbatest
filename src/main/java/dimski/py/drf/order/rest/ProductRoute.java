package dimski.py.drf.order.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/product")
public class ProductRoute {

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(){
        return ResponseEntity.status(200).body("oke");
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<Object> getProducts(){
        return ResponseEntity.status(200).body("oke");
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getProduct(@PathVariable("id") UUID productId){
        return ResponseEntity.status(200).body("oke");
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") UUID productId){
        return ResponseEntity.status(200).body("oke");
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> removeProduct(@PathVariable("id") UUID productId){
        return ResponseEntity.status(200).body("oke");
    }

}
