package org.example.Controlers;


import lombok.RequiredArgsConstructor;
import org.example.models.Basket;
import org.example.models.Product;
import org.example.services.NewBasketService;
import org.example.services.NewProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MyRestControler
{

    private final NewProductService productService;
    private final NewBasketService newBasketService;

    @GetMapping(value="/get/products")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:3000/main")
    @RolesAllowed({"User"})
    public List<Product> getAllProducts() {
        return productService.getAll();
    }
    @RolesAllowed({"User","Admin"})
    @PostMapping(value="/post/product", produces={"application/json"})
    public Product addProduct(@RequestBody Product product) {
        productService.add(product);
        return product;
    }

    @RolesAllowed({"User","Admin"})
    @DeleteMapping(value = "/delete/product/{id}", produces={"application/json"})
    public List<Product> deleteProduct(@PathVariable int id) {
        productService.delete(id);
        return productService.getAll();
    }



    @GetMapping(value="/get/basket", produces={"application/json"})
    public List<Basket> getAllBasket() {
        return newBasketService.getAll(); //получени товаров от текущего пользователя
    }

    @RolesAllowed({"User"})
    @PostMapping(value="/post/basket", produces={"application/json"})
    public Basket addBasket(@RequestBody Basket basket) {
        newBasketService.add(basket); //добавление для текущего пользователя
        return basket;
    }

    @RolesAllowed({"User"})
    @DeleteMapping(value = "/delete/basket/{id}", produces={"application/json"})
    public List<Basket> deleteMarket(@PathVariable int id) {
        newBasketService.deleteByid(id);
        return newBasketService.getAll();
    }

    @PostMapping("/clear")
    public String clearBasket() {
        newBasketService.deleteBasket();
        return "redirect:/basket";
    }

}
