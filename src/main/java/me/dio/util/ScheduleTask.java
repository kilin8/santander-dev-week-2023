package me.dio.util;

import me.dio.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask {
    private final long SEGUNDO = 1000;
    private final long MINUTO = SEGUNDO * 60;
    private final long HORA = MINUTO * 60;

    @Autowired
    private CardService cardService;

    @Scheduled(fixedDelay = MINUTO)
    public void desactivateCard() {
        System.out.println("Expired card deactivation routine");
        cardService.desactivateCard();
    }
}
