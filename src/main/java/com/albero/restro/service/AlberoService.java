package com.albero.restro.service;

import com.albero.restro.model.Drinkmenu;
import com.albero.restro.model.Foodmenu;
import com.albero.restro.model.Mailbody;
import com.albero.restro.repository.DrinkRepository;
import com.albero.restro.repository.FoodRepository;
import com.albero.restro.repository.MailBodyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlberoService {
    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private MailBodyRepository mailBodyRepository;

    public List<Foodmenu> getFoodList() {
        return foodRepository.findAll();
    }

    public List<Drinkmenu> getDrinkList(){
        return drinkRepository.findAll();
    }

    public List<Mailbody> getAllOrders() { return mailBodyRepository.findAll();}

    public Optional<Mailbody> getOrdersById(Integer id) {return mailBodyRepository.findById(id);}
}
