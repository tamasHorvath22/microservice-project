package com.codecool.microservices;

import com.codecool.microservices.dao.PresentDao;
import com.codecool.microservices.utility.JsonUtil;
import com.codecool.microservices.utility.UrlParser;

import java.text.ParseException;

public class main {
    public static void main(String[] args) throws ParseException {
        PresentDao dao = new PresentDao(new UrlParser(new JsonUtil()), new JsonUtil());
        System.out.println(dao.getAllPresents(""));
    }
}
