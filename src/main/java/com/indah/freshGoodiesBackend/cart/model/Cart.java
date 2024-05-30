package com.indah.freshGoodiesBackend.cart.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
public class Cart {
    private long id;
    private List<CartItem> items;
    private Data createdAt;
    private Data updateAt;
    private Data deleteAt;

    protected void onCreate(){
    }
    protected void onUpdate(){
    }
}
