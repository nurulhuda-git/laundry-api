package io.licht.laundryapi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.licht.laundryapi.model.Menu;
import io.licht.laundryapi.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController 
{
    @Autowired
    MenuService menuService;

    @PostMapping("/")
    public Map<String, Object> createMenu(@RequestBody Menu menu)
    {
        Map<String, Object> result = new HashMap<>();
        try {
            Menu createdMenu = menuService.createMenu(menu);

            result.put("data", createdMenu);
            result.put("status", "success");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("data", null);
            result.put("status", "failed");
        }

        return result;
    }

    @GetMapping("/")
    public Map<String, Object> getAllMenu()
    {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("data", menuService.getAllMenu());
            result.put("status", "success");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("data", null);
            result.put("status", "failed");
        }


        return result;
    }
}
