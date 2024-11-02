package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface VegetableRepository extends JpaRepository<Vegetable, Long> {

    @Query("SELECT v From Vegetable v ORDER BY v.price DESC")
    List<Vegetable> getByPriceDesc();

    @Query("Select v From Vegetable v WHERE v.name LIKE %:name%")
    List<Vegetable> searchByName(String name);

    @Query("SELECT v From Vegetable v ORDER BY v.price ASC")
    List<Vegetable> getByPriceAsc();
}
