package com.workintech.s18d2.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Validated
@Table(schema = "fsweb",name = "Fruit")
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    private Long id;
    @NotNull(message= "name can not be null")
    @Size(min=2, max=45, message= "name size must be 2 to 45")
    private String name;
    private double price;
    @Column(name = "fruit_type")
    @Enumerated(EnumType.STRING)
    @NotNull
    private FruitType fruitType;
}
