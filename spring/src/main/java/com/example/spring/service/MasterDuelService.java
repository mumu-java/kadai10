package com.example.spring.service;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import com.example.spring.controller.Deck;
import com.example.spring.exception.MasterDuelException;
import com.example.spring.mapper.MasterDuelMapper;

@Service
public class MasterDuelService {

    private final MasterDuelMapper mapper;

    public MasterDuelService(MasterDuelMapper mapper) {
        this.mapper = mapper;
    }

    public List<Deck> getNames() {
        return mapper.findAll();
    }

    public String register() throws MasterDuelException {
        try {
            int resultSeptember = mapper.insertResultSeptember();
            int resultAugust = mapper.insertResultAugust();

            if (resultSeptember > 0 && resultAugust > 0) {
                return "登録しました。";
            } else if (resultSeptember > 0) {
                throw new MasterDuelException("resultAugustが0以下です。");
            } else if (resultAugust > 0) {
                throw new MasterDuelException("resultSeptemberが0以下です。");
            } else {
                throw new MasterDuelException("登録できませんでした。");
            }
        } catch (Exception e) {
            throw new MasterDuelException("エラーが発生しました。", e);
        }
    }

    public void createDeck(Deck deck) {
    }

    public static HttpStatusCode findByTier(String tier) {
        return null;
    }
}