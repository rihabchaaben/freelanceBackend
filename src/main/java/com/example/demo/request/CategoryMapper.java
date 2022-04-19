package com.example.demo.request;

import com.example.demo.models.Category;

public class CategoryMapper {
	public static CategoryDTO entityToDTO(Category cat) {
		CategoryDTO catdto = new CategoryDTO();
		catdto.setDesignation(cat.getDesignation());                          
		catdto.setSubcategories(cat.getSubcategories());
  
    return catdto;
}

public static Category dtoToEntity(CategoryDTO catdto) {
    Category cat = new Category();
    cat.setDesignation(catdto.getDesignation());
    cat.setSubcategories(catdto.getSubcategories());

    return cat;
}
}
