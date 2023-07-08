package com.deft.blackjack.model;

/**
 * @author Sergey Golitsyn
 * created on 07.08.2023
 */
public enum PlayerActionType {
    HIT,
    STAND;

    public static boolean contains(String test) {
        for (PlayerActionType c : PlayerActionType.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }
        return false;
    }
}
