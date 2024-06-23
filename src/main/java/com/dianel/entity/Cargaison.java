package com.dianel.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cargaison {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numeroCargaison;

    @Column(nullable = false)
    private String lieuMaraillage;

    @Column(nullable = false)
    private LocalDate dateReceptionQuai;

    @ManyToOne
    private Usine usineDestination;

    @Column(nullable = false)
    private LocalDate dateReceptionUsine;

    @Column(nullable = false)
    private String numeroBonLivraison;

    @ManyToOne
    private Transporteur transporteur;

    @Column(nullable = false)
    private String typeCargaison;

    @ManyToMany
    @JoinTable(
            name = "cargaison_produit",
            joinColumns = @JoinColumn(name = "cargaison_id"),
            inverseJoinColumns = @JoinColumn(name = "produit_id")
    )
    private Set<Produit> produits;

}
