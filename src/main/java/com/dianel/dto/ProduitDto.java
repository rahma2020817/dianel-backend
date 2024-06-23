package com.dianel.dto;


import com.dianel.entity.Produit;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProduitDto {
    private String codeProduit;
    private String nom;

    private String description;
    private String amateur;
    private String taille;
    private String typeEmballage;
    private String codeChariot;

    public static Produit mapToEntity(ProduitDto produitDto) {
        return Produit.builder()
                .codeProduit(produitDto.getCodeProduit())
                .nom(produitDto.getNom())
                .description(produitDto.getDescription())
                .amateur(produitDto.getAmateur())
                .taille(produitDto.getTaille())
                .typeEmballage(produitDto.getTypeEmballage())
                .codeChariot(produitDto.getCodeChariot())
                .build();
    }

}
