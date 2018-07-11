/*
package com.codecool.microservices.dao;

import com.codecool.microservices.model.Wallet;
import com.codecool.microservices.utility.JsonUtil;
import com.codecool.microservices.utility.UrlParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;

public class WalletDao {

    private JSONObject walletJson;
    private Wallet wallet;

    @Autowired
    private UrlParser urlParser;

    @Autowired
    private JsonUtil jsonUtil;

    public Wallet getWallet() {
        getJson();
        createWalletObject();
        return wallet;
    }

    private void getJson() {
        try {
            walletJson = jsonUtil.readJsonFromUrl(urlParser.getEwalletRoute());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createWalletObject() {
        wallet = new Wallet(Long.valueOf(walletJson.get("userId").toString()),
                            Double.valueOf(walletJson.get("balance").toString()));
    }
}
*/
