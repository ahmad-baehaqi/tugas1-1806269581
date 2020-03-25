package com.apap.tugas1806269581.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * PerpustakaanModel
 */
@Entity
@Table(name = "perpustakaan")
public class PerpustakaanModel implements Serializable {

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
    @Size(max = 500)
    @Column(name = "lokasi", nullable = false)
    private String lokasi;

    public String getLokasi() {
        return this.lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    @OneToMany(mappedBy = "perpustakaan")
    private Set<JadwalPustakawanModel> setJadwal;

    public Set<JadwalPustakawanModel> getSetJadwal() {
        return this.setJadwal;
    }

    public void setSetJadwal(Set<JadwalPustakawanModel> setJadwal) {
        this.setJadwal = setJadwal;
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
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
        PerpustakaanModel other = (PerpustakaanModel) obj;
        if (id != other.id)
            return false;
        return true;
    }

}