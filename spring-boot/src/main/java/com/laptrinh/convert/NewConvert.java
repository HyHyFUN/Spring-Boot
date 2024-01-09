package com.laptrinh.convert;

import org.springframework.stereotype.Controller;

import com.laptrinh.dto.NewDTO;
import com.laptrinh.entity.NewEntity;

@Controller
public class NewConvert {

	public NewEntity toEntity(NewDTO dto) {
		NewEntity entity = new NewEntity();
		entity.setTiltle(dto.getTiltle());
		entity.setContent(dto.getContent());
		entity.setShortDescription(dto.getShortDescription());
		entity.setThumbnail(dto.getThumbnail());
		return entity;
	}

	public NewDTO toDTO(NewEntity entity) {
		NewDTO dto = new NewDTO();
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setTiltle(entity.getTiltle());
		dto.setContent(entity.getContent());
		dto.setShortDescription(entity.getShortDescription());
		dto.setThumbnail(entity.getThumbnail());
		dto.setCategoryCode(entity.getCategory().getCode());
		dto.setCategoryName(entity.getCategory().getName());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		return dto;
	}

	public NewEntity toEntity(NewDTO dto, NewEntity entity) {
		entity.setTiltle(dto.getTiltle());
		entity.setContent(dto.getContent());
		entity.setShortDescription(dto.getShortDescription());
		entity.setThumbnail(dto.getThumbnail());
		return entity;
	}

}
