package com.apap.tugas1806269581.services;

import java.util.List;
import java.util.Optional;

import com.apap.tugas1806269581.models.PerpustakaanModel;

/**
 * PerpustakaanService
 */
public interface PerpustakaanService {

    List<PerpustakaanModel> getAllPerpustakaan();

    Optional<PerpustakaanModel> getPerpustakaanById(int id);

    void addPerpustakaan(PerpustakaanModel perpustakaan);

    void deletePerpustakaan(int id);
}