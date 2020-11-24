package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Component
public class CartDaoSqlImpl implements CartDao{

	@Override
	public void addCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		Connection con=ConnectionHandler.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("insert into cart(ct_user_id,ct_menu_id) values(?,?)");
			ps.setLong(1, userId);
			ps.setLong(2,menuItemId);
			ps.executeUpdate();
			ps.clearParameters();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		// TODO Auto-generated method stub
		Connection con=ConnectionHandler.getConnection();
		List<MenuItem> lst=new ArrayList<MenuItem>();
		Cart c=new Cart(lst,0);
		MenuItem mm=null;
		try {
			PreparedStatement ps=con.prepareStatement("select user_id,name,category,price,date,active,freedelivery from cart,menu where cart.ct_menu_id=menu.user_id and ct_user_id=?");
			ps.setLong(1, userId);
			ResultSet rs=ps.executeQuery();
			ps.clearParameters();
			while(rs.next())
			{
				mm=new MenuItem(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getBoolean(6),rs.getBoolean(7),rs.getDate(5));
				lst.add(mm);
				//System.out.println(lst.get(0).getCategory());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double tot=0;
		try {
			PreparedStatement ps=con.prepareStatement("select sum(price) from cart,menu where cart.ct_menu_id=menu.user_id and ct_user_id=?");
			ps.setLong(1, userId);
			ResultSet rs=ps.executeQuery();
			ps.clearParameters();
			while(rs.next())
			tot+=rs.getFloat(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(lst.isEmpty())
			throw new CartEmptyException();
		c=new Cart(lst,tot);
		return lst;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		Connection con=ConnectionHandler.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("delete from cart where ct_user_id=? and ct_menu_id=?");
			ps.setLong(1,userId);
			ps.setLong(2,menuItemId);
			ps.executeUpdate();
			ps.clearParameters();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}