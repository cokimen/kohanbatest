package dimski.py.drf.order.serviceimpl;

import dimski.py.drf.models.Product;
import dimski.py.drf.order.repos.ProductJPARepo;
import dimski.py.drf.order.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;


public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductJPARepo productJPARepo;

    @Override
    public Product addProduct(Product product) {
        return productJPARepo.save(product);
    }

    @Override
    public Product editProduct(Product product) {
         Optional<Product> p = productJPARepo.findById(product.getId());
         if (p.isPresent()) {
              p = Optional.of(productJPARepo.save(product));
         }
         return p.get();
    }

    @Override
    public Product getProductById(UUID productId) {
        Optional<Product> p = productJPARepo.findById(productId);
        return p.get();
    }

    public ArrayList<Product> getProducts(){
        return (ArrayList<Product>) productJPARepo.findAll();
    }
}
