package com.zinko.dto;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.Length;

import java.util.List;

@Embeddable
@Data
public class RestaurantDto {

    private String title;


    @ElementCollection
    @CollectionTable(name = "restaurant_images", joinColumns = @JoinColumn(name = "restaurant_id"))
    @Column(name = "image_url", length = 1000)
    private List<String> images;


    private String description;

    private Long id;
 }
