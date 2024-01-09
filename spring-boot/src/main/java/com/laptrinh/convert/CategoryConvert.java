package com.laptrinh.convert;

import org.springframework.stereotype.Controller;

import com.laptrinh.dto.CategoryDTO;
import com.laptrinh.entity.CategoryEntity;

@Controller
public class CategoryConvert {

	public CategoryEntity toEntity(CategoryDTO dto) {
		CategoryEntity entity = new CategoryEntity();
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		return entity;
	}

	public CategoryDTO toDTO(CategoryEntity entity) {
		CategoryDTO dto = new CategoryDTO();
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		return dto;
	}

	public CategoryEntity toEntity(CategoryDTO dto, CategoryEntity entity) {
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		return entity;
	}

}
