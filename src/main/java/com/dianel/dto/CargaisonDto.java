package com.dianel.dto;

import com.dianel.entity.Cargaison;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;


@Getter
@Setter
@Builder
public class CargaisonDto {

    private String numeroCargaison;

    private String lieuMaraillage;

    private LocalDate dateReceptionQuai;

    private Long usineDestinationId;

    private LocalDate dateReceptionUsine;

    private String numeroBonLivraison;

    private Long transporteurId;
    private String typeCargaison;
    private Set<Long> produitIds;




}
