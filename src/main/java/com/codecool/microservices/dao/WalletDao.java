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

    public void createWallet(long userId) {
        JSONObject sum = new JSONObject();
        sum.put("userId", userId);

        String urlParameters = sum.toString();

        jsonUtil.sendPostRequestForPresents(urlParser.getEwalletRoute(), urlParameters);
//        try{
//            String urlParameters =
//                    "userId=" + URLEncoder.encode(Long.toString(userId), "UTF-8");
//            jsonUtil.sendPostRequest(urlParser.getEwalletRoute() ,urlParameters);
//        }
//        catch (UnsupportedEncodingException ex){
//            ex.printStackTrace();
//        }
    }

    public Wallet getWallet(long userId) {
        try {
            walletJson = jsonUtil.readJsonFromUrl(urlParser.getEwalletRoute() + "user/" + userId);
            createWalletObject();
            return wallet;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deposit(long userId, double amount) {
        JSONObject sum = new JSONObject();
        sum.put("userId", userId);
        sum.put("sum", amount);

        String urlParameters = sum.toString();
        jsonUtil.sendPutRequest(urlParser.getEwalletRoute() + "deposit", urlParameters);
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
