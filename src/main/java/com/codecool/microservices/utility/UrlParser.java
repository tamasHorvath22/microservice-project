package com.codecool.microservices.utility;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class UrlParser {
    private JsonUtil jsonUtil;
    private final String configPath = "src/main/java/com/codecool/microservices/config/urlconfig.json";

    private JSONObject urls;

    public UrlParser(JsonUtil jsonUtil) {
        this.jsonUtil = jsonUtil;
        urls = jsonUtil.getJson(configPath);
    }

    public JsonUtil getJsonUtil() {
        return jsonUtil;
    }

    public String getWishlistRoute(){
        return (String)urls.get("wishlistroute");
    }

    public String getOrderRoute(){
        return (String)urls.get("orderroute");
    }

    public String getEwalletRoute(){
        return (String)urls.get("ewalletroute");
    }
    
    public String getCartRoute(){
        return (String)urls.get("cartroute");
    }

    public String getPresentRoute(){
        return (String)urls.get("presentroute");
    }

    public String getCommunicationRoute(){
        return (String)urls.get("communicationroute");
    }

    public String getUserRoute(){
        return (String)urls.get("userroute");
    }
}
