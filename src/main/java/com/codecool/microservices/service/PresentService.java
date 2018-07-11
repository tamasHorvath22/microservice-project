package com.codecool.microservices.service;

import com.codecool.microservices.dao.PresentDao;
import com.codecool.microservices.model.Present;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresentService {

    @Autowired
    private PresentDao presentDao;

    public List<Present> getPresentsByUserId(long id){
        return presentDao.getAllPresentById(id);
    }
}
