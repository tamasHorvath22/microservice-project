package com.codecool.microservices.dao;

import com.codecool.microservices.utility.JsonUtil;
import com.codecool.microservices.utility.UrlParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Component
public class WishlistDao {

    private UrlParser urlParser;
    private JsonUtil jsonUtil;

    public WishlistDao(UrlParser urlParser, JsonUtil jsonUtil) {
        this.urlParser = urlParser;
        this.jsonUtil = jsonUtil;
    }

    public void addPresent(long userId, long presentId){
        try{
            String urlParameters =
                    "userId=" + URLEncoder.encode(Long.toString(userId), "UTF-8") +
                            "&presentId=" + URLEncoder.encode(Long.toString(presentId), "UTF-8");
            jsonUtil.sendPostRequest(urlParser.getWishlistRoute(),urlParameters);
        }
        catch (UnsupportedEncodingException ex){
            ex.printStackTrace();
        }
    }

    public void removePresent(long userId, long presentId){
        jsonUtil.sendDeleteRequest(urlParser.getWishlistRoute() +"?userId="+ userId +"&presentId="+ presentId);
    }

    public List<Long> getWishlist(long userId){
        JSONObject jsonObject = null;
        try {
            jsonObject = jsonUtil.readJsonFromUrl(urlParser.getWishlistRoute() + "/" + Long.toString(userId));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Long> list = new ArrayList<>();
        JSONArray jsonArray = (JSONArray)jsonObject.get("presentIds");
        if (jsonArray != null) {
            int len = jsonArray.length();
            for (int i=0;i<len;i++){
                list.add(Long.valueOf((Integer)jsonArray.get(i)));
            }
        }
        return list;
    }

}
