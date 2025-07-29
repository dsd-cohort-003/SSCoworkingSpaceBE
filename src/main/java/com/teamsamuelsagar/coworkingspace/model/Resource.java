package com.teamsamuelsagar.coworkingspace.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resource")
public class Resource {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String description;
    private BigDecimal price;
    private String category;

    @ManyToOne
    private Office office;
}