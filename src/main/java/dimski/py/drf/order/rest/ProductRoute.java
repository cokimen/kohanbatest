package dimski.py.drf.order.rest;

import dimski.py.drf.models.Product;
import dimski.py.drf.order.dto.ProductRequest;
import dimski.py.drf.order.dto.ResponseStd;
import dimski.py.drf.order.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/product")
public class ProductRoute {

    @Autowired
    ProductService productService;

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody ProductRequest productRequest){
        Product product = productService.addProduct(productRequest.createProduct());
        System.out.println(product.toString());
        return ResponseEntity.status(200).body(
                ResponseStd.genResponse(200, product).getBodyJson()
        );
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<Object> getProducts(){
        return ResponseEntity.status(200).body(
                ResponseStd.genResponse(200, productService.getProducts() ).getBodyJson()
        );
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getProduct(@PathVariable("id") UUID productId){
        System.out.println(productService.getProductById(productId).toString());
        return ResponseEntity.status(200).body(
                ResponseStd.genResponse(200, productService.getProductById(productId)).getBodyJson()
        );
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") UUID productId, @RequestBody ProductRequest productRequest){
        Product product = productService.getProductById(productId);
        product.setProductDescription(productRequest.getProductDescription());
        product.setProductPrice(product.getProductPrice());
        product.setStock(productRequest.getStock());
        product.setState(product.getState());
        product.setId(productId);
        productService.editProduct(product);

        return ResponseEntity.status(200).body(
                ResponseStd.genResponse(200, product).getBodyJson()
        );
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> removeProduct(@PathVariable("id") UUID productId){
        Product product = productService.deleteProduct(productId);

        return ResponseEntity.status(200).body(
                ResponseStd.genResponse(200, product).getBodyJson()
        );
    }

}
