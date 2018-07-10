package com.codecool.microservices.utility;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.Iterator;

@Component
public class JsonUtil {
    private JSONParser parser = new JSONParser();

    public JSONObject getJson(String path){
        try {
            Object obj = parser.parse(new FileReader(
                    path));
            return (JSONObject) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
