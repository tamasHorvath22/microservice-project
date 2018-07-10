package com.codecool.microservices.dao;

import com.codecool.microservices.model.Present;
import com.codecool.microservices.utility.JsonUtil;
import com.codecool.microservices.utility.UrlParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PresentDao {

    @Autowired
    private UrlParser urlParser;

    @Autowired
    private JsonUtil jsonUtil;

    private JSONObject presentJSON;

    private void getPresentJson(){
        presentJSON = ???.getJson(urlParser.getPresentRoute());
    }

    private Present makePresentFromJson(){
        Integer id = Integer.valueOf(presentJSON.get("id").toString());
        String name = presentJSON.get("name").toString();
        double price = Double.valueOf(presentJSON.get("price").toString());
        String category = presentJSON.get("category").toString();
        boolean available = Boolean.valueOf(presentJSON.get("available").toString());
        Integer ownerId = Integer.valueOf(presentJSON.get("ownerid").toString());
        return new Present(id, name, price, category, available, ownerId);
    }
}
