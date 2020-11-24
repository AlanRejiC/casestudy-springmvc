package com.cognizant.truyum.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@Controller
public class MenuItemController {

	@Autowired
	MenuItemService menuItemService;

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	@GetMapping(value = "/show-menu-list-admin")
	public String showMenuItemListAdmin(ModelMap model) {
		LOGGER.info("Start");
		model.addAttribute("menuItemList", menuItemService.getMenuListAdmin());
		LOGGER.info("End");
		// System.out.println("Hello");
		return "menu-item-list-admin";
	}

	@GetMapping(value = "/show-menu-list-customer")
	public String showMenuItemListCustomer(ModelMap model) {
		LOGGER.info("Start");
		model.addAttribute("menuItemList", menuItemService.getMenuListCustomer());
		LOGGER.info("End");
		return "menu-item-list-customer";
	}

	@GetMapping(value = "/show-edit-menu-item")
	public String showEditMenuItem(@RequestParam long menuItemId, ModelMap model) {
		LOGGER.info("Startinf edit menu");
		MenuItem item = menuItemService.getMenuItem(menuItemId);
		List<String> categories = Arrays.asList(new String[] { "Starters", "Main Course", "Desert", "Drinks" });
		model.addAttribute("menuItem", item);
		model.addAttribute("catogoryList", categories);
		LOGGER.info("Ending edit menu");
		return "edit-menu-item";
	}

}
