package com.example.spring.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.spring.controller.Deck;
import com.example.spring.exception.MasterDuelException;
import com.example.spring.mapper.MasterDuelMapper;
import com.example.spring.response.MasterDuelResponse;

@Service
public class MasterDuelService {

    private final MasterDuelMapper<MasterDuelResponse> mapper;

    public MasterDuelService(MasterDuelMapper<MasterDuelResponse> mapper) {
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
                throw new MasterDuelException("resultAが0以下です。");
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

    public static ResponseEntity<String> findByTier(int tier) {
        return ResponseEntity.ok("正常に終了しました。");
    }

    public void updateDeck(Deck deck, int tier) {
        String updatedDeckName = deck.getDeck();
        String updatedTier = String.valueOf(tier);

        System.out.println("Updated Deck Name: " + updatedDeckName);
        System.out.println("Updated Tier: " + updatedTier);

        // データベースの更新処理を行う
        mapper.updateDeck(updatedDeckName, updatedTier);
    }
}
