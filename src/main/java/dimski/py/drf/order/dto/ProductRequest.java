package dimski.py.drf.order.dto;


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
}
