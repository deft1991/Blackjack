package com.deft.blackjack.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlackJackHandTest {

    @Test
    void score() {
        BlackJackHand basicHand = new BlackJackHand();
        BlackJackCard a = new BlackJackCard(2, SuitType.Club);
        BlackJackCard b = new BlackJackCard(3, SuitType.Club);
        basicHand.addCard(a);
        basicHand.addCard(b);
        int score = basicHand.score();

        assertEquals(score, 5);
    }

    @Test
    void busted() {
        BlackJackHand basicHand = new BlackJackHand();
        BlackJackCard a = new BlackJackCard(9, SuitType.Club);
        BlackJackCard b = new BlackJackCard(9, SuitType.Club);
        BlackJackCard c = new BlackJackCard(9, SuitType.Club);
        basicHand.addCard(a);
        basicHand.addCard(b);
        basicHand.addCard(c);
        boolean busted = basicHand.busted();

        assertTrue(busted);
    }

    @Test
    void bustedFalse() {
        BlackJackHand basicHand = new BlackJackHand();
        BlackJackCard a = new BlackJackCard(9, SuitType.Club);
        basicHand.addCard(a);
        boolean busted = basicHand.busted();

        assertFalse(busted);
    }

    @Test
    void is21() {
        BlackJackHand basicHand = new BlackJackHand();
        BlackJackCard a = new BlackJackCard(9, SuitType.Club);
        BlackJackCard b = new BlackJackCard(9, SuitType.Club);
        BlackJackCard c = new BlackJackCard(3, SuitType.Club);
        basicHand.addCard(a);
        basicHand.addCard(b);
        basicHand.addCard(c);
        boolean is21 = basicHand.is21();

        assertTrue(is21);
    }

    @Test
    void is21False() {
        BlackJackHand basicHand = new BlackJackHand();
        BlackJackCard a = new BlackJackCard(9, SuitType.Club);
        BlackJackCard b = new BlackJackCard(9, SuitType.Club);
        basicHand.addCard(a);
        basicHand.addCard(b);
        boolean is21 = basicHand.is21();

        assertFalse(is21);
    }

    @Test
    void isBlackJack() {
        BlackJackHand basicHand = new BlackJackHand();
        BlackJackCard a = new BlackJackCard(11, SuitType.Club);
        BlackJackCard b = new BlackJackCard(1, SuitType.Club);
        basicHand.addCard(a);
        basicHand.addCard(b);
        boolean isBlackJack = basicHand.isBlackJack();

        assertTrue(isBlackJack);
    }

    @Test
    void isBlackJackFalse() {
        BlackJackHand basicHand = new BlackJackHand();
        BlackJackCard a = new BlackJackCard(9, SuitType.Club);
        BlackJackCard b = new BlackJackCard(1, SuitType.Club);
        basicHand.addCard(a);
        basicHand.addCard(b);
        boolean isBlackJack = basicHand.isBlackJack();

        assertFalse(isBlackJack);
    }
}
