package com.example.spring.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.spring.form.MasterDuelForm;
import com.example.spring.response.MasterDuelResponse.DeckCreateResponse;
import com.example.spring.response.MasterDuelResponse.DeckDeleteResponse;
import com.example.spring.response.MasterDuelResponse.DeckUpdateResponse;
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
    public ResponseEntity<String> findbyTier(@PathVariable("Tier") String Tier) {
        return new ResponseEntity<String>(HttpStatus.OK);
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
                .path("/MasterDuel/" + form.getTier())
                .build()
                .toUri();
        return ResponseEntity.created(uri).body(new DeckCreateResponse(deck));
    }

    @PatchMapping("/November/{tier}")
    public ResponseEntity<DeckUpdateResponse> updateDeck(
            @PathVariable("tier") int tier,
            @RequestBody @Validated MasterDuelForm form) {

        Deck deck = form.toDeck();

        System.out.println("Controller : " + form.toDeck());

        masterDuelService.updateDeck(deck, tier);

        return ResponseEntity.ok(new DeckUpdateResponse(deck));
    }

    // テーブル名を変数で受け取れるようにする

    @DeleteMapping("/{tableName}/{deck}")
    public ResponseEntity<DeckDeleteResponse> deleteDeck(
            @PathVariable("tableName") String tableName,
            @PathVariable("deck") String deck) {

        masterDuelService.deleteDeck(tableName, deck);
        return ResponseEntity.noContent().build();
    }
}
