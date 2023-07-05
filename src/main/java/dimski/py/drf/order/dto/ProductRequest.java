package dimski.py.drf.order.dto;


import dimski.py.drf.models.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class ProductRequest implements Serializable {
    private Integer productPrice;
    private String productDescription;
    private Integer stock;
    public Product createProduct(){
        Product product = new Product();
        product.setProductPrice(productPrice);
        product.setProductDescription(productDescription);
        product.setStock(stock);
        product.setState(0);
        return product;
    }
}
