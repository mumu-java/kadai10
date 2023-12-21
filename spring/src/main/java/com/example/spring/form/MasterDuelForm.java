package com.example.spring.form;

import com.example.spring.controller.Deck;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MasterDuelForm {
    @JsonProperty("Deck")
    private String deck;

    @JsonProperty("Tier")
    private int tier;

    public String getDeck() {
        return deck;
    }

    public int getTier() {
        return tier;
    }

    public void setDeck(String deck) {
        this.deck = deck;
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
