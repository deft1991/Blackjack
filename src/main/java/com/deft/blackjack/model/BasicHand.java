package com.deft.blackjack.model;

import java.util.ArrayList;

/**
 * @author Sergey Golitsyn
 * created on 07.08.2023
 *
 * Store all hand cards and calculate score
 */
public class BasicHand<T extends BasicCard> {
    protected ArrayList<T> cards = new ArrayList<>();

    public int score() {
        int score = 0;
        for (T card : cards) {
            score += card.value();
        }
        return score;
    }

    public void addCard(T card) {
        cards.add(card);
    }

    public void print() {
        for (BasicCard card : cards) {
            card.print();
        }
    }
}
