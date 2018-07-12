package com.codecool.microservices.service;

import com.codecool.microservices.dao.PresentDao;
import com.codecool.microservices.model.Present;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class PresentService {

    private PresentDao presentDao;

    public PresentService(PresentDao presentDao) {
        this.presentDao = presentDao;
    }

    public void addPresent(Present present) {
        presentDao.addPresent("", present);
    }

    public void removePresent(long presentId) {
        presentDao.removePresent(Long.toString(presentId));
    }

    public void modifyPresent(long presentId, Present present) {
        presentDao.modifyPresent("/", presentId, present);
    }

    public Present getPresent(long presentId) throws ParseException {
        return presentDao.getPresent(Long.toString(presentId));
    }

    public List<Present> getAllPresents() throws ParseException {
        return presentDao.getAllPresents("");
    }

    public List<Present> getPresentsByUserId(long id){
        return presentDao.getAllPresentById(id);
    }

    public List<Present> getFourRandomPresents() throws ParseException {
        return presentDao.getFourRandomPresents("");
    }
}
