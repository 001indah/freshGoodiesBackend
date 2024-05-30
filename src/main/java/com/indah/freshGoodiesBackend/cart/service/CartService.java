package com.indah.freshGoodiesBackend.cart.service;

import com.indah.freshGoodiesBackend.cart.model.Cart;
import com.indah.freshGoodiesBackend.cart.model.CartItem;

import java.util.List;

public interface CartService {
    CartItem addCartItem(Long cartId, Long productId, int quantity);
    List<CartItem> getAllCartItems(Long cartId);
    CartItem updateCartItem(Long cartId, Long itemId, int quantity);
    void deleteCartItem(Long cartId, Long itemId);
    Cart getCartById(Long cartId);
    Cart createCart();
    void deleteCart(Long cartId);
}
