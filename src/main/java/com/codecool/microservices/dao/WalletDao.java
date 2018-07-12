/*
package com.codecool.microservices.dao;

import com.codecool.microservices.model.Wallet;
import com.codecool.microservices.utility.JsonUtil;
import com.codecool.microservices.utility.UrlParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Component
public class WalletDao {

    private JSONObject walletJson;
    private Wallet wallet;

    @Autowired
    private UrlParser urlParser;

    @Autowired
    private JsonUtil jsonUtil;

    public Wallet getWallet() {
        return wallet;
    }

    public void createWallet(long userId) {
        try{
            String urlParameters =
                    "userId=" + URLEncoder.encode(Long.toString(userId), "UTF-8");
            jsonUtil.sendPostRequest(urlParser.getEwalletRoute() ,urlParameters);
        }
        catch (UnsupportedEncodingException ex){
            ex.printStackTrace();
        }
    }

    public void getWallet(long userId) {
        try {
            walletJson = jsonUtil.readJsonFromUrl(urlParser.getEwalletRoute() + userId);
            createWalletObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deposit(long userId, int amount) {
        try{
            String urlParameters =
                    "userId=" + URLEncoder.encode(Long.toString(userId), "UTF-8") +
                    "&sum=" + URLEncoder.encode(Integer.toString(amount), "UTF-8");
            jsonUtil.sendPutRequest(urlParser.getEwalletRoute(), urlParameters);
        }
        catch (UnsupportedEncodingException ex){
            ex.printStackTrace();
        }
    }

    public void withdraw(long userId, int amount) {
        try{
            String urlParameters =
                    "userId=" + URLEncoder.encode(Long.toString(userId), "UTF-8") +
                    "&sum=" + URLEncoder.encode(Integer.toString(amount), "UTF-8");
            jsonUtil.sendPutRequest(urlParser.getEwalletRoute(), urlParameters);
        }
        catch (UnsupportedEncodingException ex){
            ex.printStackTrace();
        }
    }

    private void createWalletObject() {
        wallet = new Wallet(Long.valueOf(walletJson.get("userId").toString()),
                            Double.valueOf(walletJson.get("balance").toString()));
    }
}
*/
