package com.codecool.microservices.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UrlParser {

    @Autowired
    private JsonUtil jsonUtil;

    public JsonUtil getJsonUtil() {
        return jsonUtil;
    }

    private final String configPath = "src/main/java/com/codecool/microservices/config/urlconfig.json";
    
    public String getWishlistRoute(){
        return (String)jsonUtil.getJson(configPath).get("wishlistroute");
    }

    public String getOrderRoute(){
        return (String)jsonUtil.getJson(configPath).get("orderroute");
    }

    public String getEwalletRoute(){
        return (String)jsonUtil.getJson(configPath).get("ewalletroute");
    }
    
    public String getCartRoute(){
        return (String)jsonUtil.getJson(configPath).get("cartroute");
    }

    public String getPresentRoute(){
        return (String)jsonUtil.getJson(configPath).get("presentroute");
    }

    public String getCommunicationRoute(){
        return (String)jsonUtil.getJson(configPath).get("communicationroute");
    }

    public String getUserRoute(){
        return (String)jsonUtil.getJson(configPath).get("userroute");
    }
}
