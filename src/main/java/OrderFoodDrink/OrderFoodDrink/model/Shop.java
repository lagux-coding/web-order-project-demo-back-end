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
@Table(name = "Shop")
@Builder
@AllArgsConstructor
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer shopId;

    @Column(columnDefinition = "NVARCHAR(256)")
    String shopName;

    @Column(columnDefinition = "NVARCHAR(256)")
    String address;

    public Shop() {
    }
}
