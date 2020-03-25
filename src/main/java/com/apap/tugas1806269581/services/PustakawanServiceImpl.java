package com.apap.tugas1806269581.services;

import java.util.List;

import com.apap.tugas1806269581.models.PustakawanModel;
import com.apap.tugas1806269581.repositories.PustakawanDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PustakawanServiceImpl
 */
@Service
@Transactional
public class PustakawanServiceImpl implements PustakawanService {

    @Autowired
    private PustakawanDb pustakawanDb;

    @Override
    public List<PustakawanModel> getAllPustakawan() {
        return pustakawanDb.findAll();
    }

    @Override
    public PustakawanModel getPustakawanById(int id) {
        return pustakawanDb.findById(id);
    }

    @Override
    public PustakawanModel getPustakawanByNip(String nip) {
        return pustakawanDb.findByNip(nip);
    }

    @Override
    public void generateNip(PustakawanModel pustakawan) {
        pustakawan.setNip(pustakawan.generateNip());
    }

    @Override
    public void addPustakawan(PustakawanModel pustakawan) {
        this.generateNip(pustakawan);
        for (PustakawanModel p : this.getAllPustakawan()) {
            if (p.getNip().equals(pustakawan.getNip())) {
                this.generateNip(pustakawan);
            }
        }
        pustakawanDb.save(pustakawan);
    }

    @Override
    public void updatePustakawan(int id, PustakawanModel updatePustakawan) {
        PustakawanModel pustakawan = this.getPustakawanById(id);
        pustakawan.setNama(updatePustakawan.getNama());
        pustakawan.setTempatLahir(updatePustakawan.getTempatLahir());
        pustakawan.setTanggalLahir(updatePustakawan.getTanggalLahir());
        pustakawan.setJenisKelamin(updatePustakawan.getJenisKelamin());
        pustakawan.setSetSpesialisasi(updatePustakawan.getSetSpesialisasi());
    }

    public void deletePustakawan(int id) {
        pustakawanDb.delete(this.getPustakawanById(id));
    }

    @Override
    public void addJadwal(int id, PustakawanModel updatePustakawan) {
        PustakawanModel pustakawan = this.getPustakawanById(id);
        pustakawan.setSetJadwal(updatePustakawan.getSetJadwal());
    }
}