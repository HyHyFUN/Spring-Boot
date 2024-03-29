package com.laptrinh.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.laptrinh.dto.NewDTO;
import com.laptrinh.service.INewService;

@Controller
@RequestMapping("news")
public class NewController {
	
	@Autowired
	private INewService newService;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listNews", newService.getListAll());
		model.addAttribute("listCategory", newService.getListAllCategory());
		return "home-news";
	}
	
	@PostMapping(value = "/new")
	@ResponseBody
	public NewDTO createNew(@RequestBody NewDTO newDTO) {
		return newService.save(newDTO);
	}
	
	@PostMapping(value = "/new/delete")
	@ResponseBody
	public NewDTO deleteNew(@RequestBody NewDTO newDTO) {
		return newService.deleteNew(newDTO.getId());
	}

}
