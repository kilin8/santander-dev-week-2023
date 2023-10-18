package me.dio.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Random;

@Entity(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String number;

    private String agency;

    @Column(precision = 13, scale = 2)
    private BigDecimal balance;

    @Column(name = "additional_limit", precision = 13, scale = 2)
    private BigDecimal limit;

    public String generateRandomAgency() {
        Random random = new Random();
        int randomDigits = 10000 + random.nextInt(90000);
        int randomLastDigit = random.nextInt(10);
        return String.format("%05d-%d", randomDigits, randomLastDigit);
    }

    public String generateRandomAccount() {
        Random random = new Random();
        int firstPart = random.nextInt(10000);
        int secondPart = random.nextInt(10);
        return String.format("%04d-%d", firstPart, secondPart);
    }

    public Account(int balance){
        this.setAgency(generateRandomAgency());
        this.setNumber(generateRandomAccount());
        this.balance = BigDecimal.valueOf(balance);

        Random random = new Random();
        int randomValue = random.nextInt(1001);
        this.limit = BigDecimal.valueOf(randomValue);
    }
    public Account() {

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

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

}
