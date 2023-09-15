package com.mindsim.petroapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "medida")
public class Medida {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tagid")
    private Integer id;
    @Column(name = "_timestamp")
    private LocalDateTime timestamp;
    private Double valor;
}
