package com.example.spring.form;

import com.example.spring.controller.Deck;

public class MasterDuelForm {
    @NotBlank(message = "デッキ名は必須です")
    private String deck;
    @Min(value = 1, message = "ティアは1以上の値である必要があります")
    private int tier;

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public Deck toDeck() {
        Deck deck = new Deck();
        deck.setDeck(this.deck);
        deck.setTier(this.tier);
        return deck;
    }
}
