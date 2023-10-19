package me.dio.domain.model.dto;

import java.math.BigDecimal;

public class UserDTO {
    private String name;
    private int balance;

    public UserDTO(String name, int balance){
        super();
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
