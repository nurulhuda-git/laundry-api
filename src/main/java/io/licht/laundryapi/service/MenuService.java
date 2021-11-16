package io.licht.laundryapi.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.licht.laundryapi.model.Menu;

@Service
public class MenuService 
{
    public Map<Integer, Menu> menuRepository = new HashMap<>();

    public Menu createMenu(Menu menu)
    {
        int min = 100000;
        int max = 1000000000;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);

        menu.setCreateBy("Admin");
        menu.setId(random_int);
        menu.setCreateAt(new Date(System.currentTimeMillis()));
        
        menuRepository.put(menu.getId(), menu);
        
        return menuRepository.get(menu.getId());
    }

    public Map<Integer, Menu> getAllMenu()
    {
        return menuRepository;
    }

    public Menu getMenuById(Integer id)
    {
        return menuRepository.get(id);
    }
    
}
