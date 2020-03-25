package com.apap.tugas1806269581.models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * PustakawanModel
 */
@Entity
@Table(name = "pustakawan")
public class PustakawanModel implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    @Size(max = 50)
    @Column(name = "nama", nullable = false)
    private String nama;

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @NotNull
    @Size(max = 20)
    @Column(name = "nip", nullable = false, unique = true)
    private String nip;

    public String getNip() {
        return this.nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    @Size(max = 100)
    @Column(name = "tempat_lahir")
    private String tempatLahir;

    public String getTempatLahir() {
        return this.tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    @NotNull
    @Column(name = "tanggal_lahir", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalLahir;

    public Date getTanggalLahir() {
        return this.tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    @NotNull
    @Column(name = "jenis_kelamin", nullable = false)
    private int jenisKelamin;

    public int getJenisKelamin() {
        return this.jenisKelamin;
    }

    public void setJenisKelamin(int jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "spesialisasi_pustakawan", joinColumns = {
            @JoinColumn(name = "pustakawan_id") }, inverseJoinColumns = { @JoinColumn(name = "spesialisasi_id") })
    private Set<SpesialisasiModel> setSpesialisasi = new HashSet<>();

    public Set<SpesialisasiModel> getSetSpesialisasi() {
        return this.setSpesialisasi;
    }

    public void setSetSpesialisasi(Set<SpesialisasiModel> setSpesialisasi) {
        this.setSpesialisasi = setSpesialisasi;
    }

    @OneToMany(mappedBy = "pustakawan", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<JadwalPustakawanModel> setJadwal;

    public Set<JadwalPustakawanModel> getSetJadwal() {
        return this.setJadwal;
    }

    public void setSetJadwal(Set<JadwalPustakawanModel> setJadwal) {
        this.setJadwal = setJadwal;
    }

    @Override
    public int hashCode() {
        Objects.hash(id);
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PustakawanModel other = (PustakawanModel) obj;
        if (id != other.id)
            return false;
        return true;
    }

    public String generateNip() {
        String rndm = getTwoCharRandom();
        return LocalDate.now().getYear() + new SimpleDateFormat("ddMMyy").format(getTanggalLahir())
                + this.getJenisKelamin() + rndm;
    }

    protected String getTwoCharRandom() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 2) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

}