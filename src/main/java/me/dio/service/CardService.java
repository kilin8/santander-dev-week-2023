package me.dio.service;

import jakarta.persistence.EntityNotFoundException;
import me.dio.domain.model.Card;
import me.dio.domain.model.TypeCard;
import me.dio.domain.model.User;
import me.dio.domain.repository.CardRepository;
import me.dio.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private UserRepository userRepository;
    public void desactivateCard() {
        LocalDateTime currentDate = LocalDateTime.now();
        List<Card> cards = cardRepository.findByAtiveIsTrueAndDateHourExpireIsBefore(currentDate);
        for (Card card : cards) {
            card.setAtive(false);
        }
        cardRepository.saveAll(cards);
    }

    public Card create(Long id, TypeCard type){
        Card card = cardRepository.findCardToCreate(id, type.toString());
        LocalDateTime now = LocalDateTime.now();
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        if (card == null) {
            card = new Card();
            card.setNumber(card.generateRandomNumber());
            card.setAtive(true);
            card.setType(type);
            Random random = new Random();
            int randomValue = random.nextInt(10001);
            card.setLimit(BigDecimal.valueOf(randomValue));
            if (type.equals(TypeCard.PHYSICAL)) {
                LocalDateTime expireDateTime = now.plusYears(3).withHour(23).withMinute(59).withSecond(59);
                card.setDateHourExpire(expireDateTime);
            } else if (type.equals(TypeCard.VIRTUAL)) {
                Duration oneHour = Duration.ofHours(1);
                LocalDateTime expireTime = now.plus(oneHour);
                card.setDateHourExpire(expireTime);
            }
            user.getCard().add(card);
            userRepository.save(user);
            return card;
        } else {
            return card;
        }
    }

}
