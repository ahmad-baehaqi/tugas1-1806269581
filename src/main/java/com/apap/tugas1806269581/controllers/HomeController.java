package com.apap.tugas1806269581.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.apap.tugas1806269581.models.PustakawanModel;
import com.apap.tugas1806269581.services.*;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * PilotController
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    private String home() {
        return "home";
    }

}