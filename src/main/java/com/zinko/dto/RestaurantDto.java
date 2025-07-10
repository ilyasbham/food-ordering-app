package com.zinko.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import org.hibernate.Length;

import java.util.List;

@Embeddable
@Data
public class RestaurantDto {

    private String title;


    @Column(Length=1000)
    private List<String> images;

    private String description;

    private Long id;
 }
