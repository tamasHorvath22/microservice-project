package com.codecool.microservices.dao;

import com.codecool.microservices.model.Present;
import com.codecool.microservices.utility.JsonUtil;
import com.codecool.microservices.utility.UrlParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class PresentDao {

    @Autowired
    private UrlParser urlParser;

    @Autowired
    private JsonUtil jsonUtil;

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
        Integer ownerId = Integer.valueOf(presentJSON.get("ownerid").toString());
        String timeStampString = presentJSON.get("timestamp").toString();
        DateFormat format = new SimpleDateFormat("YYYY-mm-dd");
        Date timestamp = format.parse(timeStampString);
        return new Present(id, name, price, category, available, ownerId, timestamp);
    }

    public Present getPresent(String route) throws ParseException{
        getPresentJson(route);
        return makePresentFromJson();
    }
}
