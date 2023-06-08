package com.damiantomczyszyn.bookstore.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
@Data
@AllArgsConstructor
public class AddToCartDto {
    private Long id;
    private @NotNull  Long productID;
    private @NotNull Integer quantity;




}
