package com.zinko.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


import java.util.ArrayList;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String fullname;

    private String email;

    private String password;

    private USER_ROLE role;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
    private List<Order> orders=new ArrayList<>();


    @ManyToMany
    @JoinTable(
            name = "user_favorites",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "restaurant_id")
    )
    private List<Restaurant> favorites = new ArrayList<>();

     @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
     private List<Address> addresses = new ArrayList<>();
}
