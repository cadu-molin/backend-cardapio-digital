package com.cardapiodigital.controller;

import com.cardapiodigital.dtos.FoodRequestDTO;
import com.cardapiodigital.dtos.FoodResponseDTO;
import com.cardapiodigital.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<FoodResponseDTO>> getAll() {
        return ResponseEntity.ok(foodService.findAll());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<FoodResponseDTO> saveFood(@RequestBody FoodRequestDTO foodRequestDTO) {
        return new ResponseEntity<>(foodService.save(foodRequestDTO), HttpStatus.CREATED);
    }
}
