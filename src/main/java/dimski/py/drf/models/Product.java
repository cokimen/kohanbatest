package dimski.py.drf.models;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.UUID;
import java.util.Set;
import java.util.List;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "product_id", columnDefinition = "VARCHAR(36)", nullable = false, updatable = false)
    @Type(type = "uuid-char")
    private UUID id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Order> orders;

    @Column(nullable = false)
    private Integer productPrice;

    @Column
    private String productDescription;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Integer state;

}
