package com.laptrinh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinh.convert.CategoryConvert;
import com.laptrinh.convert.NewConvert;
import com.laptrinh.dto.CategoryDTO;
import com.laptrinh.dto.NewDTO;
import com.laptrinh.entity.CategoryEntity;
import com.laptrinh.entity.NewEntity;
import com.laptrinh.repository.CategoryRepository;
import com.laptrinh.repository.NewRepository;
import com.laptrinh.service.INewService;

@Service
public class NewService implements INewService {
	
	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private NewConvert newConvert;
	
	@Autowired
	private CategoryConvert categoryConvert;

	@Override
	public NewDTO save(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();
		if (newDTO.getId() != null) {
			NewEntity oldEntity = newRepository.findOne(newDTO.getId());
			newEntity = newConvert.toEntity(newDTO, oldEntity);
		} else {
			newEntity = newConvert.toEntity(newDTO);
		}
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		newEntity.setCategory(categoryEntity);
		newRepository.save(newEntity);
		return newConvert.toDTO(newEntity);
	}

	@Override
	public NewDTO deleteNew(Long id) {
		NewEntity newEntity = newRepository.findOne(id);
		newRepository.delete(id);
		return newConvert.toDTO(newEntity);
	}

	@Override
	public List<NewDTO> getListAll() {
		List<NewEntity> listEntity = newRepository.findAll();
		List<NewDTO> listDisplay = new ArrayList<>();
		for(NewEntity entity: listEntity) {
			listDisplay.add(newConvert.toDTO(entity));
		}
		return listDisplay;
	}

	@Override
	public List<CategoryDTO> getListAllCategory() {
		List<CategoryEntity> listEntity = categoryRepository.findAll();
		List<CategoryDTO> listDisplay = new ArrayList<>();
		for(CategoryEntity entity: listEntity) {
			listDisplay.add(categoryConvert.toDTO(entity));
		}
		return listDisplay;
	}

}
