package com.codecool.microservices;

import com.codecool.microservices.dao.PresentDao;
import com.codecool.microservices.model.Present;
import com.codecool.microservices.service.PresentService;
import com.codecool.microservices.utility.JsonUtil;
import com.codecool.microservices.utility.UrlParser;
import com.google.gson.annotations.JsonAdapter;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        JsonUtil jsonUtil = new JsonUtil();
        UrlParser urlParser = new UrlParser(jsonUtil);
        PresentDao presentDao = new PresentDao(urlParser, jsonUtil);
        PresentService presentService = new PresentService(presentDao);

        presentService.addPresent(new Present(1, "termék1", "ez egy termék kecske", 15D, "állat",true, 5,
                "http://ocdn.eu/pulscms-transforms/1/maRktkqTURBXy9jMmUxNTU1YTRjZjU5N2E5YzQ4NTQ3MzE1ZmVhMmU1ZS5qcGVnkpUDAgDNCEPNBKWTBc0DFM0BvA",
                new Date()));
        presentService.addPresent(new Present(1, "termék2", "ez egy termék kecske", 15D, "állat",true, 5,
                "http://ocdn.eu/pulscms-transforms/1/maRktkqTURBXy9jMmUxNTU1YTRjZjU5N2E5YzQ4NTQ3MzE1ZmVhMmU1ZS5qcGVnkpUDAgDNCEPNBKWTBc0DFM0BvA",
                new Date()));
        presentService.addPresent(new Present(1, "termék3", "ez egy termék kecske", 15D, "állat",true, 5,
                "http://ocdn.eu/pulscms-transforms/1/maRktkqTURBXy9jMmUxNTU1YTRjZjU5N2E5YzQ4NTQ3MzE1ZmVhMmU1ZS5qcGVnkpUDAgDNCEPNBKWTBc0DFM0BvA",
                new Date()));
        presentService.addPresent(new Present(1, "termék4", "ez egy termék kecske", 15D, "állat",true, 5,
                "http://ocdn.eu/pulscms-transforms/1/maRktkqTURBXy9jMmUxNTU1YTRjZjU5N2E5YzQ4NTQ3MzE1ZmVhMmU1ZS5qcGVnkpUDAgDNCEPNBKWTBc0DFM0BvA",
                new Date()));
        presentService.addPresent(new Present(1, "termék5", "ez egy termék kecske", 15D, "állat",true, 5,
                "http://ocdn.eu/pulscms-transforms/1/maRktkqTURBXy9jMmUxNTU1YTRjZjU5N2E5YzQ4NTQ3MzE1ZmVhMmU1ZS5qcGVnkpUDAgDNCEPNBKWTBc0DFM0BvA",
                new Date()));
    }
}
