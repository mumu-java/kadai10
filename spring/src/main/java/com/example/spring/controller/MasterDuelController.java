package com.example.spring.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.spring.form.MasterDuelForm;
import com.example.spring.response.MasterDuelResponse.DeckCreateResponse;
import com.example.spring.service.MasterDuelService;

@RestController
@RequestMapping("/MasterDuel")
public class MasterDuelController {

    private final MasterDuelService masterDuelService;

    public MasterDuelController(MasterDuelService masterDuelService) {
        this.masterDuelService = masterDuelService;
    }

    @GetMapping("/September")
    public List<Deck> getDeckNames() {
        List<Deck> decks = masterDuelService.getNames();
        return decks;
    }

    @GetMapping("/{Tier}")
    public ResponseEntity findbyTier(@PathVariable("Tier") String Tier) {
        return new ResponseEntity(MasterDuelService.findByTier(Tier));
    }

    @PostMapping("/September")
    public ResponseEntity<DeckCreateResponse> createDeck(
            @RequestBody @Validated MasterDuelForm form, UriComponentsBuilder uriBuilder) {
        // Deck クラスのインスタンス化と使用に関する処理が必要

        // 例: Deck クラスのインスタンスを作成し、サービスに渡して処理を行う
        Deck deck = new Deck();
        deck.setDeck(form.getDeck());
        deck.setTier(form.getTier());
        masterDuelService.createDeck(deck);

        // URI の構築
        URI uri = uriBuilder
                .path("/Master_Duel/" + form.getTier())
                .build()
                .toUri();
        return ResponseEntity.created(uri).body(new DeckCreateResponse(deck));
    }
}
