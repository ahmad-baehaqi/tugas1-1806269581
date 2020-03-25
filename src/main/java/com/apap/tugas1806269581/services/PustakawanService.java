package com.apap.tugas1806269581.services;

import java.util.List;

import com.apap.tugas1806269581.models.PustakawanModel;

/**
 * PustakawanService
 */
public interface PustakawanService {
    List<PustakawanModel> getAllPustakawan();

    PustakawanModel getPustakawanById(int id);

    PustakawanModel getPustakawanByNip(String nip);

    void generateNip(PustakawanModel pustakawan);

    void addPustakawan(PustakawanModel pustakawan);

    void addJadwal(int id, PustakawanModel pustakawan);

    void updatePustakawan(int id, PustakawanModel pustakawan);

    void deletePustakawan(int id);

}