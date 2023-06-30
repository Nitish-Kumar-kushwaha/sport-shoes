package com.phase3.phase3.Controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phase3.phase3.model.Cart;
import com.phase3.phase3.service.CartServiceImpl;

@RestController
@CrossOrigin("*")
public class CartController {

    @Autowired
    CartServiceImpl cs;

    @GetMapping(value = "/cart/products/{userName}")
    public ResponseEntity<List<Cart>> showProducts(@PathVariable String userName) {
        List<Cart> products = cs.ShowProduct(userName);
        for (Cart x : products) {
            System.out.println(x);
        }
        if (!products.isEmpty()) {
            return new ResponseEntity<List<Cart>>(products, HttpStatus.OK);
        }
        return new ResponseEntity("cart is empty by this username", HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/cart/quantity")
    public ResponseEntity<Integer> showQuantity(@RequestParam String name, @RequestParam String userName) {
        int res = cs.Quantity(name, userName);

        return new ResponseEntity<Integer>(res, HttpStatus.OK);
    }

    @PostMapping(value = "/cart/add")
    public ResponseEntity<String> addToCart(@RequestBody Cart product) {
        System.out.println(product);
        List<Cart> Product1 = cs.ShowProduct(product.getUserName());

        Optional<Cart> filteredProduct = Product1.stream().filter(prod -> prod.getName().equals(product.getName()))
                .findFirst();
        System.out.println("product filtered!!!!");

        if (!filteredProduct.isPresent()) {
            product.setQuantity(1);
            String res = cs.AddToCart(product);
            if (!res.equals("Error")) {
                return new ResponseEntity<String>("added", HttpStatus.OK);
            }
        }
        if (filteredProduct.isPresent()) {
            Cart existingProduct = filteredProduct.get();

            int quantity = existingProduct.getQuantity() + 1;
            System.out.println("quantity : " + quantity);
            existingProduct.setQuantity(quantity);
            System.out.println(existingProduct);
            System.out.println("product updated.!!!!");
            String res = cs.UpdateCart(existingProduct);
            if (!res.equals("Error")) {
                return new ResponseEntity<String>("Updated", HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>("not added", HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/cart/Product/inc")
    public ResponseEntity<String> addMoreToCart(@RequestBody Cart product) {
        System.out.println("inside ----------------------------------------------");
        System.out.println(product);
        List<Cart> Product1 = cs.ShowProduct(product.getUserName());

        Optional<Cart> filteredProduct = Product1.stream().filter(prod -> prod.getName().equals(product.getName()))
                .findFirst();
        System.out.println("product filtered!!!!");
        if (filteredProduct.isPresent()) {
            Cart existingProduct = filteredProduct.get();

            int quantity = existingProduct.getQuantity() + 1;
            System.out.println("quantity : " + quantity);
            existingProduct.setQuantity(quantity);
            System.out.println(existingProduct);
            System.out.println("product updated.!!!!");
            String res = cs.UpdateCart(existingProduct);
            if (!res.equals("Error")) {
                return new ResponseEntity<String>("Updated", HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>("not added", HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/cart/Product/dec")
    public ResponseEntity<String> removeOneByOneFromCart(@RequestBody Cart product) {
        System.out.println("inside ----------------------------------------------");
        System.out.println(product);
        List<Cart> Product1 = cs.ShowProduct(product.getUserName());

        Optional<Cart> filteredProduct = Product1.stream().filter(prod -> prod.getName().equals(product.getName()))
                .findFirst();
        System.out.println("product filtered!!!!");
        if (filteredProduct.isPresent()) {
            Cart existingProduct = filteredProduct.get();
            if (existingProduct.getQuantity() == 1) {
                cs.Delete(existingProduct);
                return new ResponseEntity<String>("Updated", HttpStatus.OK);
            } else {
                int quantity = existingProduct.getQuantity() - 1;
                System.out.println("quantity : " + quantity);
                existingProduct.setQuantity(quantity);
                System.out.println(existingProduct);
                System.out.println("product updated.!!!!");
                String res = cs.UpdateCart(existingProduct);
                if (!res.equals("Error")) {
                    return new ResponseEntity<String>("Updated", HttpStatus.OK);
                }

            }

        }
        return new ResponseEntity<String>("not added", HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/cart/Product/delete")
    public ResponseEntity<String> deleteProduct(@RequestBody Cart product) {
        List<Cart> Product1 = cs.ShowProduct(product.getUserName());

        Optional<Cart> filteredProduct = Product1.stream().filter(prod -> prod.getName().equals(product.getName()))
                .findFirst();
        if (filteredProduct.isPresent()) {
            Cart existingProduct = filteredProduct.get();
            cs.Delete(existingProduct);
            return new ResponseEntity<String>("Deleted", HttpStatus.OK);

        }

        return new ResponseEntity<String>("not deleted", HttpStatus.NOT_FOUND);
    }

}
