package com.laptrinh.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinh.dto.NewDTO;
import com.laptrinh.service.INewService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class NewApi {

	@Autowired
	private INewService newService;
	
	@PostMapping(value = "/new")
	public NewDTO createNew(@RequestBody NewDTO newDTO) {
		return newService.save(newDTO);
	}
	
	@PutMapping(value = "/new/{id}")
	public NewDTO updateNew(@RequestBody NewDTO newDTO, @PathVariable("id") long id) {
		newDTO.setId(id);
		return newService.save(newDTO);
	}
	
	@DeleteMapping(value = "/new/{id}")
	public NewDTO deleteNew(@PathVariable("id") long id) {
		return newService.deleteNew(id);
	}

}