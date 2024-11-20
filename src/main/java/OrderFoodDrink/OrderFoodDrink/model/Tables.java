package OrderFoodDrink.OrderFoodDrink.model;

import OrderFoodDrink.OrderFoodDrink.model.Enums.TableStatusEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Tables")
@Builder
@AllArgsConstructor
public class Tables {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer tableId;

    Integer tableNumber;

    @OneToMany(mappedBy = "tables")
    private List<Order> orders;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    TableStatusEnum status;

    public Tables() {
    }
}
