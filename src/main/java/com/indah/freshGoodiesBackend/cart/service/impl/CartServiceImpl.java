package com.indah.freshGoodiesBackend.cart.service.impl;
import com.indah.freshGoodiesBackend.products.service.ProductService;
import com.indah.freshGoodiesBackend.cart.model.Cart;
import com.indah.freshGoodiesBackend.cart.model.CartItem;
import com.indah.freshGoodiesBackend.cart.service.CartService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class CartServiceImpl implements CartService {
    private final Map<Long, Cart> carts = new HashMap<>();

    @Override
    public CartItem addCartItem(Long cartId, Long productId, int quantity) {
      return null;
    }

    @Override
    public List<CartItem> getAllCartItems(Long cartId) {
        return null;
    }

    @Override
    public CartItem updateCartItem(Long cartId, Long itemId, int quantity) {
        return null;
    }

    @Override
    public void deleteCartItem(Long cartId, Long itemId) {

    }

    @Override
    public Cart getCartById(Long cartId) {
        return null;
    }

    @Override
    public Cart createCart() {
        return null;
    }

    @Override
    public void deleteCart(Long cartId) {

    }
}

