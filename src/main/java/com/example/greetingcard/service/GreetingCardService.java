package com.example.greetingcard.service;

import com.example.greetingcard.dto.GreetingCardDTO;
import com.example.greetingcard.entity.GreetingCard;
import com.example.greetingcard.exception.ResourceNotFoundException;
import com.example.greetingcard.repository.GreetingCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GreetingCardService {

    @Autowired
    private GreetingCardRepository repository;
    public List<GreetingCard> getAllGreetingCards() {
        return repository.findAll();
    }
    public List<GreetingCardDTO> getAllCards() {
        return repository.findAll()
                .stream()
                .map(card -> new GreetingCardDTO(card.getTitle(), card.getMessage(), card.getSender()))
                .collect(Collectors.toList());
    }

    public GreetingCardDTO getCardById(Long id) {
        GreetingCard card = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Greeting Card not found with id: " + id));

        return new GreetingCardDTO(card.getTitle(), card.getMessage(), card.getSender());
    }

    public GreetingCardDTO createCard(GreetingCardDTO cardDTO) {
        GreetingCard card = new GreetingCard();
        card.setTitle(cardDTO.getTitle());
        card.setMessage(cardDTO.getMessage());
        card.setSender(cardDTO.getSender());

        GreetingCard savedCard = repository.save(card);
        return new GreetingCardDTO(savedCard.getTitle(), savedCard.getMessage(), savedCard.getSender());
    }

    public void deleteCard(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Greeting Card not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
