package io.licht.laundryapi.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.licht.laundryapi.model.Menu;
import io.licht.laundryapi.repository.MenuRepository;

@Service
public class MenuService 
{
    @Autowired
    MenuRepository menuRepository;

    public Menu createMenu(Menu menu)
    {
        menu.setCreateAt(new Date(System.currentTimeMillis()));
        return menuRepository.save(menu);
    }

    public List<Menu> getAllMenu()
    {
        return menuRepository.findAll();
    }

    public Menu getMenuById(UUID id)
    {
        return menuRepository.findById(id).get();
    }
    
}
