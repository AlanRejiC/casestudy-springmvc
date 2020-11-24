package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

	public static void main(String args[])
	{
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
	}
	
	static void testAddCartItem()
	{
		CartDao cartDao=new CartDaoSqlImpl();
		cartDao.addCartItem(1,100023);
		//cartDao.addCartItem(1,100100);
		List<MenuItem> mm=null;
		try {
		mm=cartDao.getAllCartItems(1);
		for(MenuItem mn:mm)
		System.out.println(mn.getId()+" "+mn.getName()+" "+mn.getCategory()+" "+mn.getPrice()+" "+mn.getDateOfLaunch());
		}
		catch(Exception e)
		{
			System.out.println("Cart Empty");
		}
		
	}
	
	static void testGetAllCartItems()
	{
		CartDao cartDao=new CartDaoSqlImpl();
		List<MenuItem> mm=null;
		try {
		mm=cartDao.getAllCartItems(1);
		for(MenuItem mn:mm)
		System.out.println(mn.getId()+" "+mn.getName()+" "+mn.getCategory()+" "+mn.getPrice()+" "+mn.getDateOfLaunch());
		}
		catch(Exception e)
		{
			System.out.println("Cart Empty");
		}
	}
	
	static void testRemoveCartItem()
	{
		CartDao cartDao=new CartDaoSqlImpl();
		cartDao.removeCartItem(1,101000);
		try
		{
		cartDao.getAllCartItems(1);
		}
		catch(Exception e)
		{
			System.out.println("Cart Empty");
		}
	}
}