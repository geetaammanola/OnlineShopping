package com.ks.ShoppingBackEnd.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ks.ShoppingBackEnd.dao.CategoryDAO;
import com.ks.ShoppingBackEnd.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category category = new Category();
		
		//ADDING FIRST category
		category.setId(1);
		category.setName("Television");
		category.setDescription("This IS Some Description For television !");
		category.setImageURL("Cat_1.png");
		
		categories.add(category);
		
		
		//Second Category
        category = new Category();
		
		
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This IS Some Description For Mobile !");
		category.setImageURL("Cat_2.png");
		
		categories.add(category);
		
        category = new Category();
		
		//ADDING 3rd category
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This IS Some Description For Laptop !");
		category.setImageURL("Cat_3.png");
		
		categories.add(category);
	}
	
	

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}



	@Override
	public Category get(int id) {
		// enhance for loop
		for(Category category: categories){
			if(category.getId()== id)return category;
		}
		return null;
	}



	@Override
	@Transactional
	public boolean add(Category category) {
		try{
			//add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			
				
			return true;
		}
		
		catch(Exception ex){
			ex.printStackTrace();
			return false;
			
		}
		
	}

}





