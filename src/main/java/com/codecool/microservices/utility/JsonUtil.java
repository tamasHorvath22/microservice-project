package com.codecool.microservices.utility;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
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

    public void sendDeleteRequest(String url){
        try{
            URL websiteURL = new URL(url);
            HttpURLConnection con = (HttpURLConnection)websiteURL.openConnection();
            con.setRequestMethod("DELETE");
            new BufferedReader(new InputStreamReader(con.getInputStream()));
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public String sendPostRequest(String targetURL, String urlParameters) {
        HttpURLConnection connection = null;

        try {
            //Create connection
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length",
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream (
                    connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }


}
