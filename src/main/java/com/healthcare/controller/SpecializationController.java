package com.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.healthcare.entity.specialization.Specialization;
import com.healthcare.service.ISpecializationService;

@Controller
@RequestMapping("/spec")
public class SpecializationController {
	@Autowired
	private ISpecializationService service;

	/* 1. Show Register Page */

	@GetMapping("/reg")
	public String showReg() {
		return "SpecializationRegister";
	}

	/* 2. On Submit from save Data */
	@PostMapping("/save")
	public String addSpec(Model model, @ModelAttribute Specialization spec) {
		service.saveSpecialization(spec);
		return "redirect:SpecializationRegister";
	}

	/* 3. Get All Specialization Data */
	@GetMapping("/all")
	public String viewAll(Model model) {
		List<Specialization> list = service.getAllSpecializations();
		model.addAttribute("list", list);
		return "SpecializationData";
	}
	/* 4. Get Specialization Data by Id */

}
