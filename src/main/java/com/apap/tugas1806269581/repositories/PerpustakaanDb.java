package com.apap.tugas1806269581.repositories;

import java.util.Optional;

import com.apap.tugas1806269581.models.PerpustakaanModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PerpustakaanDb
 */
@Repository
public interface PerpustakaanDb extends JpaRepository<PerpustakaanModel, Long> {
    Optional<PerpustakaanModel> findById(int id);
}