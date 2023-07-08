package com.deft.blackjack.model;

/**
 * @author Sergey Golitsyn
 * created on 07.08.2023
 */
public enum PlayType {
    AGAIN,
    EXIT;

    public static boolean contains(String test) {
        for (PlayType c : PlayType.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }
        return false;
    }
}
