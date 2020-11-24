package com.cognizant.truyum.controller;

import java.nio.file.FileSystemException;
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
    MenuItemService menuItemDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

    @GetMapping(value = "/show-menu-list-admin")
    public String showMenuItemListAdmin(ModelMap model) throws FileSystemException {
        LOGGER.info("Start - showMenuItemListAdmin");
        model.addAttribute("menuItemListAdmin", menuItemDao.getMenuListAdmin());
        LOGGER.info("End - showMenuItemListAdmin");
        System.out.println("Hello");
        return "menu-item-list-admin";
    }

   

}
