package me.dio.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    private TipoCartao type;

    @Column(name = "expire")
    private LocalDateTime dateHourExpire;

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

    public TipoCartao getType() {
        return type;
    }

    public void setType(TipoCartao type) {
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
