package com.codecool.microservices.dao;

import com.codecool.microservices.model.Present;
import com.codecool.microservices.utility.JsonUtil;
import com.codecool.microservices.utility.UrlParser;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class PresentDao {

    private UrlParser urlParser;

    private JsonUtil jsonUtil;

    private JSONObject presentJSON;

    public PresentDao(UrlParser urlParser, JsonUtil jsonUtil) {
        this.urlParser = urlParser;
        this.jsonUtil = jsonUtil;
    }

    private void getPresentJson(String route) {
        try {
            presentJSON = jsonUtil.readJsonFromUrl(urlParser.getPresentRoute() + route);
        } catch (IOException ex) {
            System.out.println("No JSON found...");
        }
    }

    private Present makePresentFromJson() {
        return new Gson().fromJson(presentJSON.toString(), Present.class);
    }

    public List<Present> getAllPresents(String route) {
        getPresentJson(route);
        List<Present> list = new ArrayList<>();
        JSONArray jsonArray = (JSONArray) presentJSON.get("presents");
        if (jsonArray != null) {
            int len = jsonArray.length();
            for (int i = 0; i < len; i++) {
                presentJSON = (JSONObject) jsonArray.get(i);
                list.add(makePresentFromJson());
            }
        }
        return list;
    }

    public void removePresent(String route) {
        jsonUtil.sendDeleteRequest(urlParser.getPresentRoute() + route);
    }

    public void modifyPresent(String route, long presentId, Present present) {
        jsonUtil.sendPutRequest(urlParser.getPresentRoute() + route, present.toString());
    }

    public void addPresent(String route, Present present) {
        JSONObject newPresent = new JSONObject();
        newPresent.put("name", present.getName());
        newPresent.put("category", present.getCategory());
        newPresent.put("description", present.getDescription());
        newPresent.put("imageUrl", present.getImageUrl());
        newPresent.put("price", present.getPrice());
        newPresent.put("userId", present.getOwnerId());

        String urlParameters =
                "" + newPresent.toString();
        jsonUtil.sendPostRequestForPresents(urlParser.getPresentRoute() + route, urlParameters);
    }

    public Present getPresent(String route) {
        getPresentJson(route);
        return makePresentFromJson();
    }

    public List<Present> getAllPresentById(long id){
        List<Present> presents = new ArrayList<>();
        DateFormat format = new SimpleDateFormat("YYYY-mm-dd");
        try{
            String route = urlParser.getUserRoute() + "user/" + id;
            JSONObject response = jsonUtil.readJsonFromUrl(route );
            JSONArray jsonArray = (JSONArray)response.get("presents");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject json = (JSONObject) jsonArray.get(i);
                Present present = new Present(json.getInt("id"),
                        json.getString("name"),
                        json.getString("description"),
                        json.getDouble("price"),
                        json.getString("category"),
                        json.getBoolean("available"),
                        json.getInt("userId"),
                        json.getString("imageUrl"),
                        format.parse(json.getString("creation")));
                presents.add(present);
            }
        } catch (IOException | ParseException ex){
            ex.printStackTrace();
        }
        return presents;
    }
}
