package com.deft.blackjack.model;

/**
 * @author Sergey Golitsyn
 * created on 07.08.2023
 */
public class BlackJackCard extends BasicCard {

    public BlackJackCard(int faceValue, SuitType suitType) {
        super(faceValue, suitType);
    }

    public int value() {
        if (isAce()) { // Ace
            return ACE_MIN_VALUE;
        } else if (isFaceCard()) { // Face card
            return FACE_MAX_VALUE;
        } else { // Number card
            return faceValue;
        }
    }

    public int minValue() {
        if (isAce()) { // Ace
            return ACE_MIN_VALUE;
        } else {
            return value();
        }
    }

    public int maxValue() {
        if (isAce()) { // Ace
            return ACE_MAX_VALUE;
        } else {
            return value();
        }
    }

    public boolean isAce() {
        return faceValue == ACE_MIN_VALUE;
    }

    public boolean isFaceCard() {
        // faceValue >= 11 && faceValue <= 13
        return faceValue >= ACE_MAX_VALUE && faceValue <= FACE_CARD_MAX_VALUE;
    }
}
