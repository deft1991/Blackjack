package com.deft.blackjack.model;

/**
 * @author Sergey Golitsyn
 * created on 07.08.2023
 *
 * Suit enum for Cards
 */
public enum SuitType {
    Club(0),
    Diamond(1),
    Heart(2),
    Spade(3);

    private final int value;

    SuitType(int v) {
        value = v;
    }

    public int getValue() {
        return value;
    }

    public static SuitType getSuitTypeByValue(int value) {
        return switch (value) {
            case 0 -> SuitType.Club;
            case 1 -> SuitType.Diamond;
            case 2 -> SuitType.Heart;
            case 3 -> SuitType.Spade;
            default -> null;
        };
    }
}
