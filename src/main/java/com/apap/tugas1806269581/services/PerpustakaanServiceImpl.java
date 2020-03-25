package com.apap.tugas1806269581.services;

import java.util.List;
import java.util.Optional;

import com.apap.tugas1806269581.models.PerpustakaanModel;
import com.apap.tugas1806269581.repositories.PerpustakaanDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PerpustakaanServiceImpl
 */
@Service
@Transactional
public class PerpustakaanServiceImpl implements PerpustakaanService {

    @Autowired
    private PerpustakaanDb perpustakaanDb;

    @Override
    public List<PerpustakaanModel> getAllPerpustakaan() {
        return perpustakaanDb.findAll();
    }

    @Override
    public Optional<PerpustakaanModel> getPerpustakaanById(int id) {
        return perpustakaanDb.findById(id);
    }

    @Override
    public void addPerpustakaan(PerpustakaanModel perpustakaan) {
        perpustakaanDb.save(perpustakaan);
    }

    @Override
    public void deletePerpustakaan(int id) {
        perpustakaanDb.delete(this.getPerpustakaanById(id).get());
    }
}