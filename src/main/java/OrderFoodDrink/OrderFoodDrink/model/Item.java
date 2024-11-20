package OrderFoodDrink.OrderFoodDrink.model;

import OrderFoodDrink.OrderFoodDrink.model.Enums.ItemStatusEnum;
import OrderFoodDrink.OrderFoodDrink.model.Enums.ItemType;
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
@Table(name = "Item")
@Builder
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer itemId;

    @Column(nullable = false, columnDefinition = "NVARCHAR(256)")
    String itemName;

    String description;

    double price;

    String imageUrl;

    @Column(name = "addedDate", updatable = false)
    LocalDateTime addedDate;

    @PrePersist
    protected void onCreate() {
        addedDate = LocalDateTime.now();
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ItemType typeStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ItemStatusEnum status;

    @OneToMany(mappedBy = "item")
    private List<OrderDetail> orderDetails;

    public Item() {
    }
}
