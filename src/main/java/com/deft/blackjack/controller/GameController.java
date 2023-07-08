package com.deft.blackjack.controller;

import com.deft.blackjack.model.PlayType;
import com.deft.blackjack.model.PlayerActionType;
import com.deft.blackjack.service.impl.BlackJackGameServiceImpl;
import com.deft.blackjack.service.InputServiceHelper;

import java.util.Scanner;

/**
 * @author Sergey Golitsyn
 * created on 07.08.2023
 */
public class GameController {

    public void startGame() {
        // Using Scanner for Getting Input from User
        Scanner scanner = new Scanner(System.in);
        int numHands = getStartHandsCount(scanner);

        BlackJackGameServiceImpl blackJackGameServiceImpl = new BlackJackGameServiceImpl(numHands);

        boolean playAgain = true;

        while (playAgain) {
            // initialise deck
            blackJackGameServiceImpl.initializeDeck();

            boolean success = blackJackGameServiceImpl.dealInitial();

            if (!success) {
                System.out.println("Error. Out of cards.");
                return;
            }

            System.out.println("-- Initial --");

            while (!blackJackGameServiceImpl.isGameFinished()) {
                blackJackGameServiceImpl.printCurrentHandAndScore();

                /*
                 * Go to next player if busted
                 */
                if (blackJackGameServiceImpl.isCurrentPlayerBusted()) {
                    blackJackGameServiceImpl.currentPlayerBusted();
                    blackJackGameServiceImpl.nextPlayer();
                    continue;
                }

                PlayerActionType command = InputServiceHelper.askForCommand(scanner);
                switch (command) {
                    case HIT -> blackJackGameServiceImpl.playCurrentPlayerHand();
                    case STAND -> blackJackGameServiceImpl.nextPlayer();
                }
            }

            blackJackGameServiceImpl.playDealerHand();
            blackJackGameServiceImpl.printResults();
            playAgain = doPlayAgain(scanner);
            if (playAgain){
                blackJackGameServiceImpl.resetGame();
            }
        }


    }

    private static int getStartHandsCount(Scanner scanner) {
        System.out.println("Enter players count:");
        int handsCount = scanner.nextInt();
        System.out.println("Starting game with " + handsCount + " players");
        return handsCount;
    }

    private boolean doPlayAgain(Scanner scanner) {
        return InputServiceHelper.askPlayAgain(scanner) == PlayType.AGAIN;
    }
}
