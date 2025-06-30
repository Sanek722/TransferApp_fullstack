package org.example.Repository;


import org.example.models.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Integer>
{
    @Query("select u from Basket u where u.id =:id")
    Basket findByID(@Param("id") int id);

    @Query("select u from Basket u where u.full_value =:full_value")
    List<Basket> findall(@Param("full_value") int full_value);
    @Query("select bob.full_value from Basket bob where bob.id = 1")
    int getFullValue();
}
