package com.teamsamuelsagar.coworkingspace.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "desk")
public class Desk {
    @Id
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private Float price;
}
