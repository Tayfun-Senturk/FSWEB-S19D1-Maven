package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.FruitServiceImpl;
import com.workintech.s18d2.services.VegetableService;
import com.workintech.s18d2.services.VegetableServiceImpl;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/vegetable")
@RestController
public class VegetableController {
    private VegetableServiceImpl vegetableService;

    @Autowired
    public VegetableController(VegetableServiceImpl vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> getVegetableAsc() {
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Vegetable getVegetable(@Positive @PathVariable Long id) {
        return vegetableService.getById(id);
    }

    @GetMapping("/desc")
    public List<Vegetable> getVegetableDesc() {
        return vegetableService.getByPriceDesc();
    }

    @PostMapping
    public Vegetable addVegetable(@Validated @RequestBody Vegetable vegetable) {
        return vegetableService.save(vegetable);
    }

    @PostMapping("/{name}")
    public List<Vegetable> addVegetableByName(@PathVariable String name) {
        return vegetableService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Vegetable deleteVegetable(@NotNull @Positive @PathVariable Long id) {
        return vegetableService.delete(id);
    }
}
