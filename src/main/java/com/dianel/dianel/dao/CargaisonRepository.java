package com.dianel.dianel.dao;

import com.dianel.dianel.entity.Cargaison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargaisonRepository extends JpaRepository<Cargaison, Long> {

}

