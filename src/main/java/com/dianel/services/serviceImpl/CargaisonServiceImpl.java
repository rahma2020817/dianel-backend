package com.dianel.services.serviceImpl;

import com.dianel.dao.CargaisonRepository;
import com.dianel.dao.ProduitRepository;
import com.dianel.dao.TransporteurRepository;
import com.dianel.dao.UsineRepository;
import com.dianel.dto.CargaisonDto;
import com.dianel.entity.Cargaison;
import com.dianel.entity.Produit;
import com.dianel.services.CargaisonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static com.dianel.utils.Messages.CARGAISON_NON_TROUVEE;
import static com.dianel.utils.Messages.CARGAISON_SUPPRIMEE_AVEC_SUCCÈS;

@Service
@RequiredArgsConstructor
public class CargaisonServiceImpl implements CargaisonService {

    private final CargaisonRepository cargaisonRepository;
    private final UsineRepository usineRepository;
    private final TransporteurRepository transporteurRepository;
    private final ProduitRepository produitRepository;

    @Override
    public ResponseEntity<Cargaison> createCargaison(CargaisonDto cargaisonDto) {
        try {
            Cargaison cargaison = mapToEntity(cargaisonDto);

            // Persisting Cargaison to ensure it gets an ID
            Cargaison newCargaison = cargaisonRepository.save(cargaison);

            // Persisting the relationship between Cargaison and Produit
            Set<Produit> produits = new HashSet<>();
            for (Long produitId : cargaisonDto.getProduitIds()) {
                produitRepository.findById(produitId).ifPresent(produits::add);
            }

            // Adding the products to the cargaison
            newCargaison.setProduits(produits);
            newCargaison = cargaisonRepository.save(newCargaison); // Save again to update the relationship

            return new ResponseEntity<>(newCargaison, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Cargaison> getCargaisonById(Long id) {
        return cargaisonRepository.findById(id)
                .map(cargaison -> new ResponseEntity<>(cargaison, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<Cargaison> updateCargaison(Long id, CargaisonDto cargaisonDto) {
        return cargaisonRepository.findById(id)
                .map(existingCargaison -> {
                    updateEntity(existingCargaison, cargaisonDto);
                    Cargaison updatedCargaison = cargaisonRepository.save(existingCargaison);
                    return new ResponseEntity<>(updatedCargaison, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<String> deleteCargaison(Long id) {
        try {
            if (cargaisonRepository.existsById(id)) {
                cargaisonRepository.deleteById(id);
                return new ResponseEntity<>(CARGAISON_SUPPRIMEE_AVEC_SUCCÈS, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(CARGAISON_NON_TROUVEE, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Page<Cargaison>> getAllCargaisons(int page, int size) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<Cargaison> cargaisons = cargaisonRepository.findAll(pageable);
            return new ResponseEntity<>(cargaisons, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Cargaison mapToEntity(CargaisonDto cargaisonDto) {
        Set<Produit> produits = new HashSet<>();
        for (Long produitId : cargaisonDto.getProduitIds()) {
            produitRepository.findById(produitId).ifPresent(produits::add);
        }

        return Cargaison.builder()
                .numeroCargaison(cargaisonDto.getNumeroCargaison())
                .lieuMaraillage(cargaisonDto.getLieuMaraillage())
                .dateReceptionQuai(cargaisonDto.getDateReceptionQuai())
                .usineDestination(usineRepository.findById(cargaisonDto.getUsineDestinationId()).orElse(null))
                .dateReceptionUsine(cargaisonDto.getDateReceptionUsine())
                .numeroBonLivraison(cargaisonDto.getNumeroBonLivraison())
                .transporteur(transporteurRepository.findById(cargaisonDto.getTransporteurId()).orElse(null))
                .typeCargaison(cargaisonDto.getTypeCargaison())
                .produits(produits)
                .build();
    }

    private void updateEntity(Cargaison existingCargaison, CargaisonDto cargaisonDto) {
        existingCargaison.setNumeroCargaison(cargaisonDto.getNumeroCargaison());
        existingCargaison.setLieuMaraillage(cargaisonDto.getLieuMaraillage());
        existingCargaison.setDateReceptionQuai(cargaisonDto.getDateReceptionQuai());
        existingCargaison.setUsineDestination(usineRepository.findById(cargaisonDto.getUsineDestinationId()).orElse(null));
        existingCargaison.setDateReceptionUsine(cargaisonDto.getDateReceptionUsine());
        existingCargaison.setNumeroBonLivraison(cargaisonDto.getNumeroBonLivraison());
        existingCargaison.setTransporteur(transporteurRepository.findById(cargaisonDto.getTransporteurId()).orElse(null));
        existingCargaison.setTypeCargaison(cargaisonDto.getTypeCargaison());
    }
}
