package com.indah.freshGoodiesBackend.cart;

import com.indah.freshGoodiesBackend.cart.model.Cart;
import com.indah.freshGoodiesBackend.cart.model.CartItem;
import com.indah.freshGoodiesBackend.cart.service.CartService;
import com.indah.freshGoodiesBackend.products.model.Product;
import com.indah.freshGoodiesBackend.responses.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService){
    this.cartService= cartService;
    }

    @PostMapping
    public ResponseEntity<Response<Cart>> createCart(@Validated @RequestBody CartItem cartItem){
        Cart cart = cartService.createCart();
        cartService.addCartItem(cart.getId(), cartItem.getProductId(), cartItem.getQuantity());
        return Response.successfulResponse(HttpStatus.CREATED.value(), "Product added to cart", cart);
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Response<Void>> deleteCart(@PathVariable long cartId) {
        cartService.deleteCart(cartId);
        return Response.successfulResponse("Product removed from cart");
    }

    @PutMapping("/{cartId}/items/{itemsId}")
    public ResponseEntity<Response<CartItem>> updateCartItem(@PathVariable long cartId, @PathVariable Long itemId, @RequestBody CartItem cartItem) {
        CartItem updatedItem = cartService.updateCartItem(cartId, itemId, cartItem.getQuantity());
        return Response.successfulResponse("Cart item updated", updatedItem);
    }

    @GetMapping("/{cartId}/items")
    public ResponseEntity<Response<List<CartItem>>> getAllCartItems(@PathVariable Long cartId) {
        List<CartItem> items = cartService.getAllCartItems(cartId);
        return Response.successfulResponse("All cart items retrieved", items);
    }


}
