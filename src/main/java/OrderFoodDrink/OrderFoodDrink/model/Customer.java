package OrderFoodDrink.OrderFoodDrink.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Customer")
@Builder
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer customerId;

    @Column(nullable = false, unique = true)
    String phoneNumber;

    @Column(nullable = false, columnDefinition = "NVARCHAR(256)")
    String customerName;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    @Column(name = "createAt", updatable = false)
    LocalDateTime createAt;

    @PrePersist
    protected void onCreate() {
        createAt = LocalDateTime.now();
    }

    public Customer() {
    }
}
