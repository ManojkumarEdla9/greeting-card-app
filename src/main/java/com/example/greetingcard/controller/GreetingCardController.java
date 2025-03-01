package com.example.greetingcard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.greetingcard.dto.GreetingCardDTO; // Add this import
import com.example.greetingcard.service.GreetingCardService;

@RestController
@RequestMapping("/api/cards")
@CrossOrigin("*")
public class GreetingCardController {

    @Autowired
    private GreetingCardService service;

    @GetMapping
    public List<GreetingCardDTO> getAllCards() { // Corrected return type
        return service.getAllCards();
    }

    @GetMapping("/{id}")
    public GreetingCardDTO getCardById(@PathVariable Long id) {
        return service.getCardById(id);
    }

    @PostMapping
    public GreetingCardDTO createCard(@RequestBody GreetingCardDTO cardDTO) {
        return service.createCard(cardDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable Long id) {
        service.deleteCard(id);
    }
}
