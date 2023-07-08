package com.deft.blackjack.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void dealCard() {
        Deck<BlackJackCard> deck = new Deck<>();

        ArrayList<BlackJackCard> cards = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            for (int j = 0; j <= 3; j++) {
                SuitType suit = SuitType.getSuitTypeByValue(j);
                BlackJackCard card = new BlackJackCard(i, suit);
                cards.add(card);
            }
        }
        deck.setDeckOfCards(cards);
        BasicCard basicCard = deck.dealCard();
        assertNotNull(basicCard);
        assertFalse(basicCard.isAvailable());
    }
}
