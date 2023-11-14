package com.library.management.system.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.management.system.entity.Admin;
import com.library.management.system.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private AdminService adminService;

	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}

	@GetMapping("/showAddLibrarian")
	public String showAddLibrarian(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		return "view/admin/add-librarian";
	}

	@PostMapping("/addLibrarian")
	public String addLibrarian(@ModelAttribute("admin") Admin admin) {
		adminService.save(admin);
		return "redirect:/admin/viewLibrarian";
	}

	@GetMapping("/viewLibrarian")
	public String viewLibrarian(Model model) {
		List<Admin> admin = adminService.findAll();
		model.addAttribute("admin", admin);
		return "view/admin/view-librarian";
	}

	@GetMapping("/updateLibrarian")
	public String updateLibrarian(@RequestParam("adminId") int id, Model model) {
		Admin admin = adminService.findById(id);
		model.addAttribute("admin", admin);
		return "view/admin/add-librarian";
	}

	@GetMapping("/deleteLibrarian")
	public String deleteLibrarian(@RequestParam("adminId") Integer id) {
		adminService.deleteById(id);
		return "redirect:/admin/viewLibrarian";
	}
}
