package me.dio.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Duration;
import java.util.Random;

@Entity(name = "tb_card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String number;

    @Column(name = "available_limit", precision = 13, scale = 2)
    private BigDecimal limit;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TypeCard type;

    @Column(name = "expire")
    private LocalDateTime dateHourExpire;

    public Card(TypeCard type){
        LocalDateTime now = LocalDateTime.now();
        this.number = generateRandomNumber();
        this.ative = true;
        this.type = type;
        switch (type){
            case VIRTUAL:
                Duration oneHour = Duration.ofHours(1);
                LocalDateTime expireTime = now.plus(oneHour);
                this.dateHourExpire = expireTime;
            case PHYSICAL:
                LocalDateTime expireDateTime = now.plusYears(3).withHour(23).withMinute(59).withSecond(59);
                this.dateHourExpire = expireDateTime;
        }
        Random random = new Random();
        int randomValue = random.nextInt(10001);
        this.limit = BigDecimal.valueOf(randomValue);
    }
    public Card() {}

    public String generateRandomNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            if (i > 0 && i % 4 == 0) {
                sb.append(" ");
            }
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public LocalDateTime getDateHourExpire() {
        return dateHourExpire;
    }

    public void setDateHourExpire(LocalDateTime dateHourExpire) {
        this.dateHourExpire = dateHourExpire;
    }

    public boolean isAtive() {
        return ative;
    }

    public void setAtive(boolean ative) {
        this.ative = ative;
    }

    @Column(name = "ative")
    private boolean ative;

    public TypeCard getType() {
        return type;
    }

    public void setType(TypeCard type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

}
