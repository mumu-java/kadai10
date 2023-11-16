package com.example.spring.response;

import com.example.spring.controller.Deck;

public class MasterDuelResponse {
    public record DeckCreateResponse(
            int Tier,
            String Deck) {

        public DeckCreateResponse(Deck deck) {
            this(deck.getTier(),
                    deck.getDeck());
        }
    }
}
