package dimski.py.drf.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.ArrayList;


@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "order_id",  columnDefinition = "VARCHAR(36)", nullable = false, updatable = false)
    @Type(type = "uuid-char")
    private UUID orderId;

    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    @Column
    private String customerName;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private Integer quantity;


}
