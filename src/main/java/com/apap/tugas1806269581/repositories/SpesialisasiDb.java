package com.apap.tugas1806269581.repositories;

import java.util.Optional;

import com.apap.tugas1806269581.models.SpesialisasiModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SpesialisasiDb
 */
@Repository
public interface SpesialisasiDb extends JpaRepository<SpesialisasiModel, Long> {
    Optional<SpesialisasiModel> findById(int id);
}