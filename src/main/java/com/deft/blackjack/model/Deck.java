package com.deft.blackjack.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Sergey Golitsyn
 * created on 07.08.2023
 */
public class Deck<T extends BasicCard> {
    private ArrayList<T> cards;
    private int dealtIndex = 0; // marks first undealt card

    public Deck() {
    }

    public void setDeckOfCards(ArrayList<T> deckOfCards) {
        cards = deckOfCards;
    }

    /*
     Do a double shuffle
     */
    public void shuffle() {
        Collections.shuffle(cards);
        // todo add additional algorithm for shuffle
    }

    public int remainingCards() {
        return cards.size() - dealtIndex;
    }

    /**
     * For future. Auto deal
     */
    public T[] dealHand(int number) {
        if (remainingCards() < number) {
            return null;
        }

        T[] hand = (T[]) new BasicCard[number];
        int count = 0;
        while (count < number) {
            T card = dealCard();
            if (card != null) {
                hand[count] = card;
                count++;
            }
        }

        return hand;
    }

    public T dealCard() {
        if (remainingCards() == 0) {
            return null;
        }

        T card = cards.get(dealtIndex);
        card.markUnavailable();
        dealtIndex++;

        return card;
    }

    /**
     * Print deck
     */
    public void print() {
        for (BasicCard card : cards) {
            card.print();
        }
    }
}
