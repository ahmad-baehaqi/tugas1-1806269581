package com.apap.tugas1806269581.repositories;

import com.apap.tugas1806269581.models.PustakawanModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * PustakawanDb
 */
@Repository
public interface PustakawanDb extends JpaRepository<PustakawanModel, Long> {
    PustakawanModel findById(int id);

    PustakawanModel findByNip(String nip);
}