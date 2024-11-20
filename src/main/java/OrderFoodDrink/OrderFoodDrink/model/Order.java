package OrderFoodDrink.OrderFoodDrink.model;

import OrderFoodDrink.OrderFoodDrink.model.Enums.OrderStatusEnum;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Orders")
@Builder
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer orderId;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    @Column(nullable = false)
    LocalDateTime orderDate;

    @PrePersist
    protected void onCreate() {
        orderDate = LocalDateTime.now();
    }

    @Column
    Double totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    OrderStatusEnum status;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    @ManyToOne
    @JoinColumn(name = "tableId", nullable = false)
    private Tables tables;

    public Order() {
    }
}
