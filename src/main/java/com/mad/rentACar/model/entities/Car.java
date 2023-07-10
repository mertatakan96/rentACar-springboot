package com.mad.rentACar.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "cars")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "plate", unique = true)
    private String plate;
    
    @Column(name = "dailyPrice")
    private double dailyPrice;
    
    @Column(name = "modelYear")
    private int modelYear;

    @Column(name = "status")
    private int status; // 1 - Available, 2-Rented, 3-Maintenance
    
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
