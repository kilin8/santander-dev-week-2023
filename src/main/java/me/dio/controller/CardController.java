package me.dio.controller;

import me.dio.domain.model.Card;
import me.dio.domain.model.TypeCard;
import me.dio.domain.model.User;
import me.dio.domain.repository.CardRepository;
import me.dio.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cards")
public class CardController {
    @Autowired
    CardService cardService;

    @PostMapping
    public Card create(@RequestParam Long userId, @RequestParam TypeCard type) {
        return cardService.create(userId, type);
    }
}
