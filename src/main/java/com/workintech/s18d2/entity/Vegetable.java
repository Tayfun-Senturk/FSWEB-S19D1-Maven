package com.workintech.s18d2.entity;

import jakarta.persistence.*;
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
@Table(schema = "fsweb",name = "Vegetable")
public class Vegetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    private Long id;
    @NotNull
    @Size(min=2,max = 45,message = "name length must be in 2 to 45")
    private String name;
    private double price;
    @Column(name = "is_grown_on_tree")
    private boolean isGrownOnTree;
}
