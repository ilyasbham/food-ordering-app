package com.zinko.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Length;

import java.time.LocalDateTime;
import java.util.List;

import java.util.ArrayList;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToOne
    private User owner;

    private String name;

    private String description;

    private String cuisiontype;


    @OneToOne
    private Address address;


    @Embedded
    private ContactInformation contactInformation;

    private String openingHours;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> order = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "restaurant_images", joinColumns = @JoinColumn(name = "restaurant_id"))
    @Column(name = "image_url", length = 1000)
    private List<String> images;


    private LocalDateTime registrationDate;

    private boolean open;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL)
    private List<Food> foods=new ArrayList<>();









}
