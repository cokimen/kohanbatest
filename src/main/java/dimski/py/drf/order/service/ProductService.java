package dimski.py.drf.order.service;

import dimski.py.drf.models.Product;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;


@Service
public interface ProductService {
    public Product addProduct(Product product);
    public Product editProduct(Product product);
    public Product getProductById(UUID productId);

    public ArrayList<Product> getProducts();

    public Product deleteProduct(UUID productid);

}
