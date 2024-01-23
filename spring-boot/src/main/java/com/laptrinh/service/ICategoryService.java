package com.laptrinh.service;

import java.util.List;

import com.laptrinh.dto.CategoryDTO;

public interface ICategoryService {
	void save(CategoryDTO categoryDTO);
	void deleteCategory(Long id);
	List<CategoryDTO> getListAll();
	CategoryDTO getById(Long id);

}
