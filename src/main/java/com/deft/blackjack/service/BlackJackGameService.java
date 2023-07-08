package com.deft.blackjack.service;

/**
 * @author Sergey Golitsyn
 * created on 07.08.2023
 */
public interface BlackJackGameService {

    boolean dealInitial();

    void initializeDeck();

    boolean playDealerHand();

    boolean playCurrentPlayerHand();

    void printResults();

    void printCurrentHandAndScore();

    boolean isGameFinished();

    boolean isCurrentPlayerBusted();

    void nextPlayer();

    void currentPlayerBusted();
    void resetGame();
}
