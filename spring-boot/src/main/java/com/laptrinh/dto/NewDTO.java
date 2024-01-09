package com.laptrinh.dto;

public class NewDTO extends AbtractDTO<NewDTO> {

	public String tiltle;
	public String thumbnail;
	public String shortDescription;
	public String content;
	public String categoryCode;
	public String categoryName;
	
	public String getTiltle() {
		return tiltle;
	}
	public void setTiltle(String tiltle) {
		this.tiltle = tiltle;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	

}
