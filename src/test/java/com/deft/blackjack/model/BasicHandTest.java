package com.deft.blackjack.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicHandTest {

    @Test
    void score() {
        BasicHand<BlackJackCard> basicHand = new BlackJackHand();
        BlackJackCard a = new BlackJackCard(2, SuitType.Club);
        BlackJackCard b = new BlackJackCard(3, SuitType.Club);
        basicHand.addCard(a);
        basicHand.addCard(b);
        int score = basicHand.score();

        assertEquals(score, 5);

    }

    @Test
    void addCard() {
        BasicHand<BlackJackCard> basicHand = new BlackJackHand();
        BlackJackCard a = new BlackJackCard(2, SuitType.Club);
        basicHand.addCard(a);

        assertEquals(basicHand.cards.size(), 1);
    }
}
