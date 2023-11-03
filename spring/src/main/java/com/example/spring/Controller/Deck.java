package com.example.spring.Controller;

public class Deck {
    private int tier;
    private String deck;

    public Deck(int Tier, String deck) {
        this.tier = tier;
        this.deck = deck;
    }

    public Deck() {
    }

    public int getTier() {
        return tier;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck2) {
    }

    public void setTier(int tier2) {
    }
}
