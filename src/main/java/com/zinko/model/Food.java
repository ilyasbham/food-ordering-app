package com.zinko.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Length;
import java.util.Date;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private Long price;

    @ManyToOne
    private Category foodCategory;

    @ElementCollection
    @CollectionTable(name = "restaurant_images", joinColumns = @JoinColumn(name = "restaurant_id"))
    @Column(name = "image_url", length = 1000)
    private List<String> images;


    private boolean available;


    @ManyToOne
    private Restaurant restaurant;

    private boolean isVegetarian;

    private boolean isSeasonal;


    @ManyToMany
    private List<IngredientsItem> ingredients=new ArrayList<>();

    private Date creationDate;


}
