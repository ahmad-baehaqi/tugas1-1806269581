package com.apap.tugas1806269581.controllers;

import java.util.List;
import java.util.Optional;

import com.apap.tugas1806269581.models.PustakawanModel;
import com.apap.tugas1806269581.models.SpesialisasiModel;
import com.apap.tugas1806269581.services.PustakawanService;
import com.apap.tugas1806269581.services.SpesialisasiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * PustakawanController
 */
@Controller
public class PustakawanController {
    @Autowired
    private PustakawanService pustakawanService;

    @Autowired
    private SpesialisasiService spesialisasiService;

    @RequestMapping("/pustakawan/viewall")
    private String daftarPustakawan(Model model) {
        List<PustakawanModel> pustakawanList = pustakawanService.getAllPustakawan();
        List<SpesialisasiModel> spesialisasiList = spesialisasiService.getAllSpesialisasi();
        model.addAttribute("pustakawanList", pustakawanList);
        model.addAttribute("spesialisasiList", spesialisasiList);
        model.addAttribute("nav", "Daftar Pustakawan");
        return "daftar-pustakawan";
    }

    @RequestMapping(value = "/pustakawan/add", method = RequestMethod.GET)
    public String addPustakawan(Model model) {
        List<SpesialisasiModel> spesialisasiList = spesialisasiService.getAllSpesialisasi();
        PustakawanModel pustakawan = new PustakawanModel();
        pustakawan.setId(pustakawan.getId());
        model.addAttribute("spesialisasiList", spesialisasiList);
        model.addAttribute("pustakawanNew", pustakawan);
        model.addAttribute("nav", "Tambah Pustakawan");
        return "form-pustakawan";
    }

    @RequestMapping(value = "/pustakawan/add", method = RequestMethod.POST, params = { "simpan" })
    private String tambahPustakawanSimpan(
            @RequestParam(value = "spesialisasi", required = false) SpesialisasiModel spesialisasi,
            @ModelAttribute PustakawanModel pustakawan, Model model) {
        pustakawanService.addPustakawan(pustakawan);
        if (!(spesialisasi == null)) {
            Optional<SpesialisasiModel> spesialisasiId = spesialisasiService.getSpesialisasiById(spesialisasi.getId());
            pustakawan.getSetSpesialisasi().add(spesialisasiId.get());
        }
        model.addAttribute("nav", "Tambah Pustakawan");
        return "tambah";
    }

    @RequestMapping(value = "/pustakawan", method = RequestMethod.GET)
    public String lihatPustakawan(@RequestParam(value = "nip", required = true) String nip, Model model) {
        PustakawanModel pustakawan = pustakawanService.getPustakawanByNip(nip);
        model.addAttribute("pustakawan", pustakawan);
        model.addAttribute("nav", "Detail Pustakawan");
        return "detil-pustakawan";
    }

    @RequestMapping(value = "/pustakawan/update/{id}", method = RequestMethod.GET)
    private String ubahPustakawan(@PathVariable(value = "id") int id, Model model) {
        List<SpesialisasiModel> spesialisasiList = spesialisasiService.getAllSpesialisasi();
        PustakawanModel pustakawan = pustakawanService.getPustakawanById(id);
        model.addAttribute("spesialisasiList", spesialisasiList);
        model.addAttribute("pustakawan", pustakawan);
        model.addAttribute("nav", "Ubah Pustakawan");
        return "ubah-pustakawan";
    }

    @RequestMapping(value = "/pustakawan/update/{id}", method = RequestMethod.POST)
    private String SimpanUpdatePustakawan(@ModelAttribute PustakawanModel updatePustakawan,
            @PathVariable(value = "id") int id, Model model) {
        pustakawanService.updatePustakawan(id, updatePustakawan);
        model.addAttribute("nav", "Ubah Pustakawan");
        return "ubah";
    }

    @RequestMapping(value = "/pustakawan/delete/{id}")
    private String hapusPustakawan(@PathVariable(value = "id") int id, Model model) {
        pustakawanService.deletePustakawan(id);
        model.addAttribute("nav", "Hapus Pustakawan");
        return "hapus";
    }

}