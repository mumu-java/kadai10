package com.example.spring.Service;

import org.springframework.stereotype.Service;

import com.example.spring.Controller.Deck;
import com.example.spring.Exception.Master_Duel_Exception;
import com.example.spring.Mapper.Master_Duel_Mapper;

@Service
public class Master_Duel_Service {

    private final Master_Duel_Mapper mapper;

    public Master_Duel_Service(Master_Duel_Mapper mapper) {
        this.mapper = mapper;
    }

    public String register() throws Master_Duel_Exception {
        try {
            int resultSeptember = mapper.insertResultSeptember();
            int resultAugust = mapper.insertResultAugust();

            if (resultSeptember > 0 && resultAugust > 0) {
                return "登録しました。";
            } else if (resultSeptember > 0) {
                throw new Master_Duel_Exception("resultAugustが0以下です。");
            } else if (resultAugust > 0) {
                throw new Master_Duel_Exception("resultSeptemberが0以下です。");
            } else {
                throw new Master_Duel_Exception("登録できませんでした。");
            }
        } catch (Exception e) {
            throw new Master_Duel_Exception("エラーが発生しました。", e);
        }
    }

    public void createDeck(Deck deck) {
    }
}