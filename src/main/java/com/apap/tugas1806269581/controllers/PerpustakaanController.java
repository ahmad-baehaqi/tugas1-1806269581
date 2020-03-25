package com.apap.tugas1806269581.controllers;

import java.util.List;

import com.apap.tugas1806269581.models.PerpustakaanModel;
import com.apap.tugas1806269581.services.PerpustakaanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * PerpustakaanController
 */
@Controller
public class PerpustakaanController {

    @Autowired
    private PerpustakaanService perpustakaanService;

    @RequestMapping("/perpustakaan/viewall")
    private String daftarPerpustakaan(Model model) {
        List<PerpustakaanModel> perpustakaanList = perpustakaanService.getAllPerpustakaan();
        model.addAttribute("perpustakaanList", perpustakaanList);
        model.addAttribute("nav", "Daftar Perpustakaan");
        return "daftar-perpustakaan";
    }

    @RequestMapping(value = "/perpustakaan/add", method = RequestMethod.GET)
    private String tambahPerpustakaan(Model model) {
        PerpustakaanModel perpustakaan = new PerpustakaanModel();
        perpustakaan.setId(perpustakaan.getId());
        model.addAttribute("perpustakanNew", perpustakaan);
        model.addAttribute("nav", "Tambah Perpustakaan");
        return "form-perpustakaan";
    }

    @RequestMapping(value = "/perpustakaan/add", method = RequestMethod.POST)
    public String SimpanPerpustakaan(@ModelAttribute PerpustakaanModel perpustakaan, Model model) {
        perpustakaanService.addPerpustakaan(perpustakaan);
        model.addAttribute("nav", "Tambah Perpustakaan");
        return "tambah";
    }

    @RequestMapping(value = "/perpustakaan/delete/{id}")
    private String hapusPerpustakaan(@PathVariable(value = "id") int id, Model model) {
        perpustakaanService.deletePerpustakaan(id);
        model.addAttribute("nav", "Hapus Perpustakaan");
        return "hapus";
    }

}