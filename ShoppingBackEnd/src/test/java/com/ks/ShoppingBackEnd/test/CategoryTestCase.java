package com.ks.ShoppingBackEnd.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ks.ShoppingBackEnd.dao.CategoryDAO;
import com.ks.ShoppingBackEnd.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	 private Category category;
	 
	  @BeforeClass
	  public static void init() {
		  
		  context=new AnnotationConfigApplicationContext();
		  context.scan("com.ks.ShoppingBackEnd");
		  context.refresh();
		  categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		  
	  }
	  @Test
	  public void testAddCategory(){
		  
		  category = new Category();
		  
		    category.setName("Television");
			category.setDescription("This IS Some Description For television !");
			category.setImageURL("Cat_1.png");
			
			assertEquals("Successfully added a category inside the table !",true,categoryDAO.add(category));
			
		  
	  } 
	 
}
