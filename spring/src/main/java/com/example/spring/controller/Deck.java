package com.example.spring.controller;

public class Deck {
    private int tier;
    private String deck;

    public int getTier() {
        return tier;
    }

    public String getDeck() {
        return deck != null ? deck : "";
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public void setDeckName(String deckName) {
        this.deck = deckName;
    }
}
