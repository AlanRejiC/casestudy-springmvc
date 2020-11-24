package com.cognizant.truyum.dao;

import java.util.*;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;


public class MenuItemDaoSqlImplTest {
	public static void main(String srgs[])
	{
		
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
	}
	
	static void testGetMenuItemListAdmin()
	{
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> mm=menuItemDao.getMenuItemListAdmin();
		for(MenuItem mn:mm)
			System.out.println(mn.getId()+" "+mn.getName()+" "+mn.getCategory()+" "+mn.getPrice()+" "+mn.getDateOfLaunch());
	}
	
	static void testGetMenuItemListCustomer()
	{
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> mm=menuItemDao.getMenuItemListCustomer();
		for(MenuItem mn:mm)
			System.out.println(mn.getId()+" "+mn.getName()+" "+mn.getCategory()+" "+mn.getPrice()+" "+mn.getDateOfLaunch());
	}
	
	static void testModifyMenuItem()
	{
		MenuItem menuItem=new MenuItem(100023,"Kuzhi Mandi","main dish",300,true,false,DateUtil.convertToDate("20/12/2010"));
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		menuItemDao.modifyMenuItem(menuItem);
		menuItem=menuItemDao.getMenuItem(100023);
		System.out.println(menuItem.getId()+" "+menuItem.getName()+" "+menuItem.getCategory()+" "+menuItem.getPrice()+" "+menuItem.getDateOfLaunch());
	}
	
	static void testGetMenuItem()
	{
		
	}

}