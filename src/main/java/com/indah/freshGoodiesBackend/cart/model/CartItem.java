package com.indah.freshGoodiesBackend.cart.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartItem {
    @NotNull(message = "is Required")
    private long id;
    @NotNull(message = "is Required")
    private long productId;
    @NotNull(message = "is Required")
    private int quantity;
}
