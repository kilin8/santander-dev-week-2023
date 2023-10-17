package me.dio.service;

import me.dio.domain.model.Card;
import me.dio.domain.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;
    public void inativarCard() {
        LocalDateTime dataAtual = LocalDateTime.now();

        List<Card> cards = cardRepository.findByAtiveIsTrueAndDateHourExpireIsBefore(dataAtual);

        for (Card card : cards) {
            card.setAtive(false);
        }
        cardRepository.saveAll(cards);
    }
}
