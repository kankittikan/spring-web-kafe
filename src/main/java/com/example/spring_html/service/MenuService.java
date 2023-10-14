package com.example.spring_html.service;

import com.example.spring_html.entity.Category;
import com.example.spring_html.entity.Menu;
import com.example.spring_html.model.MenuRequest;
import com.example.spring_html.repository.CategoryRepository;
import com.example.spring_html.repository.MenuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * 6410450087 Kittikan Makphon
 */

@Service
public class MenuService {


    @Autowired
    private MenuRepository menuRepository;


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepository categoryRepository;


    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Menu getOneById(UUID id) {
        return menuRepository.findById(id).get();
    }



    public void createMenu(MenuRequest menu) {
        Menu record = modelMapper.map(menu, Menu.class);
        Category category =
                categoryRepository.findById(menu.getCategoryId()).get();
        record.setCategory(category);
        menuRepository.save(record);
    }
}

