package com.example.spring.Response;

import com.example.spring.Controller.Deck;

public class Master_Duel_Response {
    public record DeckCreateResponse(
            int Tier,
            String Deck) {

        public DeckCreateResponse(Deck deck) {
            this(deck.getTier(),
                    deck.getDeck());
        }
    }
}
