package com.codecool.microservices.utility;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
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

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public org.json.JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            org.json.JSONObject json = new org.json.JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
}
