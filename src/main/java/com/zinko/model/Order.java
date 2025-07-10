package com.zinko.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User customer;


    @JsonIgnore
    @ManyToOne
    private Restaurant restaurant;


    private Long totalAmount;

    private String orderStatus;

    private Date createAt;

    @ManyToOne
    private Address deliveryStatus;

    @OneToMany
    private List<OrderItem> items=new ArrayList<>();


    private int totalItem;

    private int totalPrice;



}
