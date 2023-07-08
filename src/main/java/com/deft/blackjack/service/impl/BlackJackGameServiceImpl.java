package com.deft.blackjack.service.impl;

import com.deft.blackjack.model.BlackJackCard;
import com.deft.blackjack.model.BlackJackHand;
import com.deft.blackjack.model.Deck;
import com.deft.blackjack.model.SuitType;
import com.deft.blackjack.service.BlackJackGameService;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Sergey Golitsyn
 * created on 07.08.2023
 */
public class BlackJackGameServiceImpl implements BlackJackGameService {
    private Deck<BlackJackCard> deck;
    private final BlackJackHand[] hands;

    // todo add dealer flexible strategy
    // todo check all players score - and set hit until
    //  set hit until strategy
    //  create interface
    //  create list of strategies

    private static final int[] HIT_UNTIL = new int[]{15, 16, 17, 18};

    private int currentPlayer = 0;
    private int numPlayers;

    private int dealerIdx;


    public BlackJackGameServiceImpl(int numPlayers) {
        this.numPlayers = numPlayers;
        this.dealerIdx = numPlayers;
        // add additional hand for dealer
        hands = new BlackJackHand[numPlayers + 1];
        for (int i = 0; i < numPlayers + 1; i++) {
            hands[i] = new BlackJackHand();
        }
    }

    @Override
    public boolean dealInitial() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < hands.length; j++) {
                BlackJackHand hand = hands[j];
                BlackJackCard card = deck.dealCard();
                if (card == null) {
                    return false;
                }
                hand.addCard(card);
                if (j == hands.length - 1) { // if dealer
                    System.out.println("Dealing to computer, card:  face down");
                } else {
                    System.out.println("Dealing to player " + (j + 1) + ", card: " + card);
                }
            }
        }
        return true;
    }

    @Override
    public void initializeDeck() {
        ArrayList<BlackJackCard> cards = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j <= 3; j++) {
                SuitType suit = SuitType.getSuitTypeByValue(j);
                BlackJackCard card = new BlackJackCard(i, suit);
                cards.add(card);
            }
        }

        deck = new Deck<>();
        deck.setDeckOfCards(cards);
        deck.shuffle();
    }

    @Override
    public boolean playDealerHand() {
        BlackJackHand hand = hands[hands.length - 1];
        int hitUntilIdx = ThreadLocalRandom.current().nextInt(HIT_UNTIL.length);
        while (hand.score() < HIT_UNTIL[hitUntilIdx]) {
            printCurrentHandAndScore();
            System.out.println("Dealer hits");
            BlackJackCard card = deck.dealCard();
            if (card == null) {
                return false;
            }
            hand.addCard(card);
        }
        printCurrentHandAndScore();
        System.out.println("Dealer stands");
        return true;

    }

    @Override
    public boolean playCurrentPlayerHand() {
        BlackJackHand hand = hands[currentPlayer];
        return playerPlayHand(hand);
    }

    private boolean playerPlayHand(BlackJackHand hand) {
        BlackJackCard card = deck.dealCard();
        if (card == null) {
            return false;
        }
        hand.addCard(card);
        return true;
    }

    @Override
    public void printResults() {
        BlackJackHand dealerHand = hands[dealerIdx];

        for (int i = 0; i < numPlayers; i++) {
            BlackJackHand hand = hands[i];
            int playerName = i + 1;
            if (hand.isBlackJack()) {
                System.out.println("Scoring player " + playerName + " : BLACK JACK. Player " + playerName + " wins.");
            } else if (hand.busted()) {
                System.out.println("Scoring player " + playerName + " busted. Dealer wins.");
            } else if (dealerHand.busted()) {
                System.out.println("Scoring player " + playerName + ". Dealer busted. Player " + playerName + " wins");
            } else if (hand.score() >= dealerHand.score()) {
                System.out.println("Scoring player " + playerName + " has " + hand.score() + ", dealer has " + dealerHand.score() + ". Player " + playerName + " wins.");
            } else {
                System.out.println("Scoring player " + playerName + " has " + hand.score() + ", dealer has " + dealerHand.score() + ". Dealer wins.");
            }
        }

    }

    @Override
    public void printCurrentHandAndScore() {
        System.out.print(getPlayerName() + " (" + hands[currentPlayer].score() + "): ");
        hands[currentPlayer].print();
        System.out.println();
    }

    private String getPlayerName() {
        return currentPlayer == dealerIdx ? "Dealer" : "Player " + (currentPlayer + 1);
    }

    @Override
    public boolean isGameFinished() {
        return currentPlayer == numPlayers;
    }

    @Override
    public boolean isCurrentPlayerBusted() {
        return hands[currentPlayer].busted();
    }

    @Override
    public void currentPlayerBusted() {
        System.out.println("Player " + (currentPlayer + 1) + " is busted!");
    }

    @Override
    public void resetGame() {
        currentPlayer = 0;
        for (int i = 0; i < numPlayers + 1; i++) {
            hands[i] = new BlackJackHand();
        }
    }

    @Override
    public void nextPlayer() {
        currentPlayer++;
    }
}
