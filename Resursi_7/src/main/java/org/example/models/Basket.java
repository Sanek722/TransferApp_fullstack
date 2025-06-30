package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "basket")
public class Basket
{
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "author")
    String author;
    @Column(name = "namebook")
    String namebook;
    @Column(name = "full_value")
    int full_value;
    @Column(name = "price")
    int price;
}