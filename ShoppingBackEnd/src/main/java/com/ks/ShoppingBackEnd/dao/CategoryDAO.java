package com.ks.ShoppingBackEnd.dao;

import java.util.List;

import com.ks.ShoppingBackEnd.dto.Category;

public interface CategoryDAO {
	
boolean add(Category category);
List<Category> list();
Category get(int id);

}












