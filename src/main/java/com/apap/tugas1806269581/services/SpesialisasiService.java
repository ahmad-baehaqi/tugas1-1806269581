package com.apap.tugas1806269581.services;

import java.util.List;
import java.util.Optional;

import com.apap.tugas1806269581.models.SpesialisasiModel;

/**
 * SpesialisasiService
 */
public interface SpesialisasiService {

    List<SpesialisasiModel> getAllSpesialisasi();

    Optional<SpesialisasiModel> getSpesialisasiById(Long id);
}