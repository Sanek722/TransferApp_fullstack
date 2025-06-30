package org.example.services;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.example.Repository.BasketRepository;
import org.example.Security.JwtTokenProvider;
import org.example.models.Basket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class NewBasketService
{

    @Autowired
    private BasketRepository basketRepository;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    public void add(Basket basket) {

        basket.setFull_value(jwtTokenProvider.getAuthentication().getId());
        basketRepository.saveAndFlush(basket);
    }
    public Basket getByID(int id)
    {
        return  basketRepository.findByID(id);
    }

    public void deleteByid(int id) {
        basketRepository.deleteById(id);
    }
    public void deleteBasket()
    {
        basketRepository.deleteAll();
    }

    public List<Basket> getAll()
    {
        return basketRepository.findall(jwtTokenProvider.getAuthentication().getId());
    }

    public int FullPrice()
    {
        List<Basket> baskets = basketRepository.findAll();
        int chet = 0;
        for(Basket basket : baskets)
        {
            chet += basket.getPrice();
        }
        return chet;
    }

}
