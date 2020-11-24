package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;
import com.cognizant.truyum.service.MenuItemService;

@Controller
public class CartController {

	@Autowired
	CartService cartService;
	@Autowired
	MenuItemService menuItemService;

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	@GetMapping(value="/add-to-cart")
	public String addtocart(@RequestParam long menuItemId,ModelMap model)
	{
		LOGGER.info("Start");
		model.addAttribute("status",true);
		model.addAttribute("menuItemList", menuItemService.getMenuListCustomer());
		cartService.addCartItem(1,menuItemId);
		LOGGER.info("End");
		return "menu-item-list-customer";
		
	}
	
	@GetMapping(value="/show-cart")
	public String getCartItems(ModelMap map)
	{
		LOGGER.info("Start getting all cart items");
		List<MenuItem> menuItem;
		try {
			menuItem = cartService.getAllCartItems(1);
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			LOGGER.info("Ending as cart is Empty");
			return "cart-empty";
		}
		map.addAttribute("cartList", menuItem);
		LOGGER.info("End getting all cart items");
		
		return "cart";
				
	}
	
	@GetMapping(value="/remove-cart-item")
	public String deleteCartItem(@RequestParam long menuItemId,ModelMap map)
	{
		LOGGER.info("Starting deleting");
		cartService.removeCartItem(1, menuItemId);
		map.addAttribute("status", true);
		LOGGER.info("Stoping deleting");
		return "cart";
	}
	
}