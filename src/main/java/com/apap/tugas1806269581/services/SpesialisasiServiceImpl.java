package com.apap.tugas1806269581.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.apap.tugas1806269581.models.SpesialisasiModel;
import com.apap.tugas1806269581.repositories.SpesialisasiDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SpesialisasiServiceImpl
 */
@Service
@Transactional
public class SpesialisasiServiceImpl implements SpesialisasiService {

    @Autowired
    private SpesialisasiDb spesialisasiDb;

    @Override
    public List<SpesialisasiModel> getAllSpesialisasi() {
        return spesialisasiDb.findAll();
    }

    @Override
    public Optional<SpesialisasiModel> getSpesialisasiById(Long id) {
        return spesialisasiDb.findById(id);
    }
}