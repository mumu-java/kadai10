package com.example.spring.controller;

public class Deck {
    private int tier;
    private String deck;

    public int getTier() {
        return tier;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    @Override
    public String toString() {
        return "Deck [deck=" + deck + ", tier=" + tier + "]";
    }

}