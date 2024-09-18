package com.cardapiodigital.domain;

import com.cardapiodigital.dtos.FoodRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "foods")
@Table(name = "foods")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @Column(length = 1000)
    private String image;

    private Integer price;

    public Food(FoodRequestDTO foodRequestDTO) {
        this.title = foodRequestDTO.title();
        this.image = foodRequestDTO.image();
        this.price = foodRequestDTO.price();
    }
}
