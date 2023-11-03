package com.example.spring.Controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.spring.Form.Master_Duel_Form;
import com.example.spring.Response.Master_Duel_Response.DeckCreateResponse;
import com.example.spring.Service.Master_Duel_Service;

@RestController
// クラスに<>を使うときはTを使っているとき（Tがよくわからない）
public class Master_Duel_Controller {

    private final Master_Duel_Service master_Duel_Service;

    public Master_Duel_Controller(Master_Duel_Service master_Duel_Service) {
        this.master_Duel_Service = master_Duel_Service;
    }

    @PostMapping("/MasterDuel/September")
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
