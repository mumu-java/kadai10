package com.example.spring.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.spring.form.Master_Duel_Form;
import com.example.spring.mapper.Master_Duel_Mapper;
import com.example.spring.response.Master_Duel_Response.DeckCreateResponse;
import com.example.spring.service.Master_Duel_Service;

@RestController
@RequestMapping("/MasterDuel")
public class Master_Duel_Controller {

    private final Master_Duel_Service master_Duel_Service;

    public Master_Duel_Controller(Master_Duel_Service master_Duel_Service) {
        this.master_Duel_Service = master_Duel_Service;
    }

    @Autowired
    private Master_Duel_Mapper masterDuelMapper;

    @GetMapping("/September")
    public List<Deck> getDeckNames() {
        List<Deck> decks = masterDuelMapper.findAll();
        return decks;
    }

    @GetMapping("/{Tier}")
    public ResponseEntity findbyTier(@PathVariable("Tier") String Tier) {
        return new ResponseEntity(Master_Duel_Service.findByTier(Tier));
    }

    @PostMapping("/September")
    public ResponseEntity<DeckCreateResponse> createDeck(
            @RequestBody @Validated Master_Duel_Form form, UriComponentsBuilder uriBuilder) {
        // Deck クラスのインスタンス化と使用に関する処理が必要

        // 例: Deck クラスのインスタンスを作成し、サービスに渡して処理を行う
        Deck deck = new Deck();
        deck.setDeck(form.getDeck());
        deck.setTier(form.getTier());
        master_Duel_Service.createDeck(deck);

        // URI の構築
        URI uri = uriBuilder
                .path("/Master_Duel/" + form.getTier())
                .build()
                .toUri();
        return ResponseEntity.created(uri).body(new DeckCreateResponse(deck));
    }
}
