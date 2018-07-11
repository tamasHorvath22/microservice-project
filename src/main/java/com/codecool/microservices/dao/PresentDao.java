package com.codecool.microservices.dao;

import com.codecool.microservices.model.Present;
import com.codecool.microservices.utility.JsonUtil;
import com.codecool.microservices.utility.UrlParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
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

    public PresentDao(UrlParser urlParser, JsonUtil jsonUtil) {
        this.urlParser = urlParser;
        this.jsonUtil = jsonUtil;
    }

    private JSONObject presentJSON;

    private void getPresentJson(String route){
        try {
            presentJSON = jsonUtil.readJsonFromUrl(urlParser.getPresentRoute() + route);
        } catch (IOException ex) {
            System.out.println("No JSON found...");
        }
    }

    private Present makePresentFromJson() throws ParseException{
        Integer id = Integer.valueOf(presentJSON.get("id").toString());
        String name = presentJSON.get("name").toString();
        double price = Double.valueOf(presentJSON.get("price").toString());
        String category = presentJSON.get("category").toString();
        boolean available = Boolean.valueOf(presentJSON.get("available").toString());
        Integer ownerId = Integer.valueOf(presentJSON.get("userId").toString());
        String timeStampString = presentJSON.get("creation").toString();
        DateFormat format = new SimpleDateFormat("YYYY-mm-dd");
        Date timestamp = format.parse(timeStampString);
        return new Present(id, name, price, category, available, ownerId, timestamp);
    }

    public List<Present> getAllPresents(String route) throws ParseException{
        getPresentJson(route);
        List<Present> list = new ArrayList<>();
        System.out.println(presentJSON.toString());
        JSONArray jsonArray = (JSONArray)presentJSON.get("presentList");
        if (jsonArray != null) {
            int len = jsonArray.length();
            for (int i=0;i<len;i++){
                presentJSON = (JSONObject) jsonArray.get(i);
                list.add(makePresentFromJson());
            }
        }
        return list;
    }

    public void removePresent(String route) {
        jsonUtil.sendDeleteRequest(urlParser.getPresentRoute() + route);
    }

    public void modifyPresent(String route, Present present) {
        jsonUtil.sendPutRequest(urlParser.getPresentRoute()+route, present.toString());
    }

    public Present getPresent(String route) throws ParseException{
        getPresentJson(route);
        return makePresentFromJson();
    }
}
