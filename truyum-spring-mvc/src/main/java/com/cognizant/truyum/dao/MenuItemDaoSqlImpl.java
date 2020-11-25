package com.cognizant.truyum.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;

@Component(value="menuItemDao")
public class MenuItemDaoSqlImpl implements MenuItemDao{

	public MenuItemDaoSqlImpl() {
		super();
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		Connection con=ConnectionHandler.getConnection();
		//System.out.println("Connection : "+con);
		List<MenuItem> lst=new ArrayList<MenuItem>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from menu");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{	
				MenuItem mm=new MenuItem(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getBoolean(5),rs.getBoolean(6),rs.getDate(7));
				lst.add(mm);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		// TODO Auto-generated method stub
		Connection con=ConnectionHandler.getConnection();
		List<MenuItem> lst=new ArrayList<MenuItem>();
		try {
			PreparedStatement ps=con.prepareStatement("Select * from menu where active=? && date<?");
			ps.setInt(1, 1);
			//Date date=new Date();
			ps.setDate(2,java.sql.Date.valueOf(java.time.LocalDate.now()));
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{	
				MenuItem mm=new MenuItem(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getBoolean(5),rs.getBoolean(6),rs.getDate(7));
				lst.add(mm);
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lst;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		Connection con=ConnectionHandler.getConnection();
		List<MenuItem> lst=new ArrayList<MenuItem>();
		try {
			PreparedStatement ps=con.prepareStatement("update menu set user_id=?,name=?,category=?,price=?,date=?,active=?,freedelivery=? where user_id=?");
			ps.setLong(1, menuItem.getId());
			ps.setString(2,menuItem.getName());
			ps.setString(3, menuItem.getCategory());
			ps.setFloat(4, menuItem.getPrice());
			ps.setDate(5,new java.sql.Date(menuItem.getDateOfLaunch().getTime()));
			ps.setBoolean(6,menuItem.isActive());
			ps.setBoolean(7,menuItem.isFreeDelivery());
			ps.setLong(8, menuItem.getId());
			//System.out.println(menuItem.getId()+" "+menuItem.getName()+" "+menuItem.getCategory()+" "+menuItem.getPrice()+" "+menuItem.getDateOfLaunch());
			ps.executeUpdate();
			ps.clearParameters();
			System.out.println(menuItem.getId());
			System.out.println(menuItem.getDateOfLaunch().getTime());
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		Connection con=ConnectionHandler.getConnection();
		List<MenuItem> lst=new ArrayList<MenuItem>();
		MenuItem mm=null;
		try {
			PreparedStatement ps=con.prepareStatement("Select * from menu");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{	
				mm=new MenuItem(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getBoolean(5),rs.getBoolean(6),rs.getDate(7));
				if(mm.getId()==menuItemId)
					break;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mm;
	}
	
	
}