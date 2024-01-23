package com.laptrinh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinh.convert.CategoryConvert;
import com.laptrinh.dto.CategoryDTO;
import com.laptrinh.entity.CategoryEntity;
import com.laptrinh.repository.CategoryRepository;
import com.laptrinh.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryConvert categoryConvert;
	
	@Override
	public void save(CategoryDTO dto) {
		CategoryEntity entity = new CategoryEntity();
		if (dto.getId() != null) {
			CategoryEntity oldEntity = categoryRepository.findOne(dto.getId());
			entity = categoryConvert.toEntity(dto, oldEntity);
		} else {
			entity = categoryConvert.toEntity(dto);
		}
		categoryRepository.save(entity);
	}

	@Override
	public void deleteCategory(Long id) {
		categoryRepository.delete(id);
	}

	@Override
	public List<CategoryDTO> getListAll() {
		List<CategoryEntity> listEntity = new ArrayList<>();
		List<CategoryDTO> listDTO = new ArrayList<>();
		listEntity = categoryRepository.findAll();
		for (CategoryEntity entity: listEntity) {
			listDTO.add(categoryConvert.toDTO(entity));
		}
		return listDTO;
	}

	@Override
	public CategoryDTO getById(Long id) {
		CategoryEntity entity = new CategoryEntity();
		entity = categoryRepository.findOne(id);
		
		return categoryConvert.toDTO(entity);
	}
	

}
