package dimski.py.drf.models;

import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "customer_id",  columnDefinition = "VARCHAR(36)", nullable = false, updatable = false)
    @Type(type = "uuid-char")
    private UUID customerId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Order> orders;

    @Column
    private String customerName;

    @Column
    private String address;

    @Column
    private String phone;
}
