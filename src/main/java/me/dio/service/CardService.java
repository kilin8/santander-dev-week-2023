package me.dio.service;

import me.dio.domain.model.Card;
import me.dio.domain.model.TypeCard;
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
        LocalDateTime dataAtual = LocalDateTime.now();
        List<Card> cards = cardRepository.findByAtiveIsTrueAndDateHourExpireIsBefore(dataAtual);
        for (Card card : cards) {
            card.setAtive(false);
        }
        cardRepository.saveAll(cards);
    }

    public Card create(TypeCard type, Long id){
        Card card = userRepository.findActiveCardByUserIdAndType(id, type);
        LocalDateTime now = LocalDateTime.now();
        if (card == null) {
            card.setNumber(card.generateRandomNumber());
            card.setAtive(true);
            card.setType(type);
            Random random = new Random();
            int randomValue = random.nextInt(10001);
            card.setLimit(BigDecimal.valueOf(randomValue));
            if (type.equals(TypeCard.FISICO)) {
                LocalDateTime expireDateTime = now.plusYears(3).withHour(23).withMinute(59).withSecond(59);
                card.setDateHourExpire(expireDateTime);
            } else if (type.equals(TypeCard.VIRTUAL)) {
                Duration oneHour = Duration.ofHours(1);
                LocalDateTime expireTime = now.plus(oneHour);
                card.setDateHourExpire(expireTime);
            }
            try{
                return cardRepository.save(card);
            } catch (Exception e){
                throw new IllegalArgumentException("This Account number already exists.");
            }
        } else {
            return card;
        }
    }

}
