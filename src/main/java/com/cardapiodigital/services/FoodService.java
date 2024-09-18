package com.cardapiodigital.services;

import com.cardapiodigital.domain.Food;
import com.cardapiodigital.dtos.FoodRequestDTO;
import com.cardapiodigital.dtos.FoodResponseDTO;
import com.cardapiodigital.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public List<FoodResponseDTO> findAll() {
        return foodRepository.findAll().stream().map(FoodResponseDTO::new).toList();
    }

    public FoodResponseDTO save(FoodRequestDTO foodRequestDTO) {
        Food newFood = new Food(foodRequestDTO);

        return new FoodResponseDTO(foodRepository.save(newFood));
    }
}
