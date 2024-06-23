package com.dianel.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codeProduit;

    @Column(nullable = false)
    private String nom;

    private String description;
    private String amateur;
    private String taille;
    private String typeEmballage;
    private String codeChariot;

    @ManyToMany(mappedBy = "produits")
    private Set<Cargaison> cargaisons;



}
