package com.laptrinh.service;

import java.util.List;

import com.laptrinh.dto.CategoryDTO;
import com.laptrinh.dto.NewDTO;

public interface INewService {
	NewDTO save(NewDTO newDTO);
	NewDTO deleteNew(Long id);
	List<NewDTO> getListAll();
	List<CategoryDTO> getListAllCategory();

}
