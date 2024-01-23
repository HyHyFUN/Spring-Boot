package com.laptrinh.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.laptrinh.dto.CategoryDTO;
import com.laptrinh.service.ICategoryService;

@Controller
@RequestMapping("category")
public class CategoryController {
	
	@Autowired
	private ICategoryService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<CategoryDTO> list = service.getListAll();
		model.addAttribute("listCategory", list);
		return "home-category";
	}
	
	@RequestMapping("/new")
	public String showNewCategory(Model model) {
		CategoryDTO dto = new CategoryDTO();
		model.addAttribute("category", dto);
		return "new-category";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute("category") CategoryDTO dto) {
		service.save(dto);
		return "redirect:/category/";
	}
	
	@RequestMapping("/edit/{id}")
	public String showEditCategory(@PathVariable(name = "id") Long id, Model model) {
		CategoryDTO dto = service.getById(id);
		model.addAttribute("category", dto);
		return "edit-category";
	}
	
	@RequestMapping("/delete/{id}")
	public String showDeleteCategory(@PathVariable(name = "id") Long id) {
		service.deleteCategory(id);
		return "redirect:/category/";
	}

}