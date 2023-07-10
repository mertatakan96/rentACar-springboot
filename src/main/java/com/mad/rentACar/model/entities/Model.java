package com.mad.rentACar.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Table(name = "model")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Model {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    
    @OneToMany(mappedBy = "model")
    private List<Car> cars;
    
}
