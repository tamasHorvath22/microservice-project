package com.codecool.microservices.dao;

import com.codecool.microservices.model.Wallet;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

public class WalletDao {

    private JSONObject walletJson;
    private Wallet wallet;

    @Autowired
    private JsonUtil jsonUtil;

    public Wallet getWallet() {
        getJson();
        createWalletObject();
        return wallet;
    }

    private void getJson() {
        walletJson = methodThatReturnsJson(jsonUtil.getWalletRoute);
    }

    private void createWalletObject() {
        wallet = new Wallet(walletJson.get("userId"), walletJson.get("balance"))
    }
}
