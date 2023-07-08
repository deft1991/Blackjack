package com.deft.blackjack.model;

import org.junit.jupiter.api.Test;

import static com.deft.blackjack.model.BasicCard.*;
import static org.junit.jupiter.api.Assertions.*;

class BlackJackCardTest {

    @Test
    void value() {
        BlackJackCard card = new BlackJackCard(2, SuitType.Club);
        int value = card.value();
        assertEquals(value, 2);
    }

    @Test
    void minValueAce() {
        BlackJackCard card = new BlackJackCard(1, SuitType.Club);
        int value = card.minValue();
        assertEquals(value, ACE_MIN_VALUE);
    }

    @Test
    void minValueFace() {
        BlackJackCard card = new BlackJackCard(12, SuitType.Club);
        int value = card.minValue();
        assertEquals(value, FACE_MAX_VALUE);
    }

    @Test
    void maxValue() {
        BlackJackCard card = new BlackJackCard(1, SuitType.Club);
        int value = card.maxValue();
        assertEquals(value, ACE_MAX_VALUE);
    }

    @Test
    void isAceTrue() {
        BlackJackCard card = new BlackJackCard(1, SuitType.Club);
        boolean isAce = card.isAce();
        assertTrue(isAce);
    }

    @Test
    void isAceFalse() {
        BlackJackCard card = new BlackJackCard(4, SuitType.Club);
        boolean isAce = card.isAce();
        assertFalse(isAce);
    }

    @Test
    void isFaceCardTrue() {
        BlackJackCard card = new BlackJackCard(13, SuitType.Club);
        boolean isAce = card.isFaceCard();
        assertTrue(isAce);
    }

    @Test
    void isFaceCardFalse() {
        BlackJackCard card = new BlackJackCard(7, SuitType.Club);
        boolean isAce = card.isFaceCard();
        assertFalse(isAce);
    }
}
