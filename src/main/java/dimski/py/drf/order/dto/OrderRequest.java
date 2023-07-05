package dimski.py.drf.order.dto;

import dimski.py.drf.models.Customer;
import dimski.py.drf.models.Order;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.UUID;


@Data
@NoArgsConstructor
@ToString
public class OrderRequest implements Serializable {

    private String customer;

    private String product;

    private Integer quantity;


}
