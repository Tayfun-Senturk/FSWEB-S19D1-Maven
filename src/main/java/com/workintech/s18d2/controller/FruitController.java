package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import com.workintech.s18d2.services.FruitServiceImpl;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/fruit")
@RestController
public class FruitController {
    private final FruitService fruitService;

    @GetMapping
    public List<Fruit> getFruitsAsc(){
        return fruitService.getByPriceAsc();
    }
    @GetMapping("/{id}")
    public Fruit getFruit(@Positive @PathVariable Long id){
        return fruitService.getById(id);
    }
    @GetMapping("/desc")
    public List<Fruit> getFruitsDesc(){
        return fruitService.getByPriceDesc();
    }
    @PostMapping
    public Fruit addFruit(@Validated @RequestBody Fruit fruit){
       return fruitService.save(fruit);
    }
    @GetMapping("name/{name}")
    public List<Fruit> addFruitByName(@PathVariable String name){
        return fruitService.searchByName(name);
    }
    @DeleteMapping("/{id}")
    public Fruit deleteFruit(@Positive @NotNull @PathVariable Long id){
        return fruitService.delete(id);
    }


}
