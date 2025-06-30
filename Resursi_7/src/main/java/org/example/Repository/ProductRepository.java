package org.example.Repository;


import org.example.models.Basket;
import org.example.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{
    @Query("select bob.author from Product bob where bob.id = :id")
    String findAuthorById(@Param("id") int id);
    @Query("select bob.namebook from Product bob where bob.id = :id")
    String findNamebookById(@Param("id") int id);
    @Query("select bob.price from Product bob where bob.id = :id")
    int findPriceById(@Param("id") int id);
    //запрос для подсчета количества продуктов
    @Query("select u from Basket u")
    List<Basket> countProducts();
}
