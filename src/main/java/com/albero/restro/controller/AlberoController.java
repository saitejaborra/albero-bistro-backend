package com.albero.restro.controller;

import com.albero.restro.model.Drinkmenu;
import com.albero.restro.model.Foodmenu;
import com.albero.restro.model.Mailbody;
import com.albero.restro.service.AlberoService;
import com.albero.restro.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/albero")
@CrossOrigin(origins = "*")
@Slf4j
public class AlberoController {

    @Autowired
    private AlberoService alberoService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/foodmenu")
    public ResponseEntity<List<Foodmenu>> getFoodApi()  {
        if(alberoService.getFoodList().isEmpty()) {
            throw new RuntimeException();
        }

        return ResponseEntity.ok(alberoService.getFoodList());
    }

    @GetMapping("/drinkmenu")
    public ResponseEntity<List<Drinkmenu>> getDrinkApi(){
        if(alberoService.getDrinkList().isEmpty()) {
            throw new RuntimeException();
        }
        return  ResponseEntity.ok(alberoService.getDrinkList());
    }

    @PostMapping("/postorder")
    public ResponseEntity<String> postOrder(@RequestBody Mailbody mailBody) throws MessagingException{
        log.info(mailBody.getMailfrom() + mailBody.getMessage() + mailBody.getSubject());
        emailService.SendEmail(mailBody);
        return ResponseEntity.ok("Gotcha "+ mailBody.getMailfrom()+"!! We'll get back to you as soon as we check your details");
    }

    @GetMapping("getAllOrders")
    public ResponseEntity<List<Mailbody>> getAllOrders(){
        return ResponseEntity.ok(alberoService.getAllOrders());
    }

    @GetMapping("getOrders/{orderId}")
    public ResponseEntity<Optional<Mailbody>> getAllOrders(@PathVariable Integer orderId){
        return ResponseEntity.ok(alberoService.getOrdersById(orderId));
    }

}
