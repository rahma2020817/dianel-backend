package com.dianel.dianel.dao;

import com.dianel.dianel.entity.Usine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsineRepository extends JpaRepository<Usine, Long> {
}
