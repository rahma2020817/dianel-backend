package com.dianel.dao;
import com.dianel.entity.Transporteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransporteurRepository extends JpaRepository<Transporteur, Long> {
}
