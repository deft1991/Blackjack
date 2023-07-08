package com.deft.blackjack;

import com.deft.blackjack.controller.GameController;

public class GameStarter {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.startGame();
    }

}
