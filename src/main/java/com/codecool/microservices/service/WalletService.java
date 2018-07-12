package com.codecool.microservices.service;

import com.codecool.microservices.dao.WalletDao;
import com.codecool.microservices.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WalletService {

    @Autowired
    private WalletDao walletDao;

    public void createWallet(long id) {
        walletDao.createWallet(id);
    }

    public Wallet getWallet(long id) {
        return walletDao.getWallet(id);
    }

    public void deposit(long userId, double amount) {
        walletDao.deposit(userId, amount);
    }

    public void withdraw(long userId, int amount) {
        walletDao.withdraw(userId, amount);
    }
}
