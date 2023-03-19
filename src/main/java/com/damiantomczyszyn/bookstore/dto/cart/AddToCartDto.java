package com.damiantomczyszyn.bookstore.dto.cart;

import org.jetbrains.annotations.NotNull;

public class AddToCartDto {
    private Long id;
    private @NotNull  Long productID;
    private @NotNull Integer quantity;

    public AddToCartDto(Long id, @NotNull Long productID, @NotNull Integer quantity) {
        this.id = id;
        this.productID = productID;
        this.quantity = quantity;
    }

    public AddToCartDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
