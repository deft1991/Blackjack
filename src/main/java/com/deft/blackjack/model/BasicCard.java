package com.deft.blackjack.model;

/**
 * @author Sergey Golitsyn
 * created on 07.08.2023
 */
public abstract class BasicCard {

    public static final int ACE_MAX_VALUE = 11;
    public static final int ACE_MIN_VALUE = 1;
    public static final int FACE_MAX_VALUE = 10;
    public static final int FACE_CARD_MAX_VALUE = 13;
    private boolean available = true;

    /*
     * Number or face that's on card:
     * 1            - Ace
     * 2 through 10 - Number
     * 11           - Jack
     * 12           - Queen
     * 13           - King
     */
    protected int faceValue;
    protected SuitType suitType;

    public BasicCard(int faceValue, SuitType suitType) {
        this.faceValue = faceValue;
        this.suitType = suitType;
    }

    public abstract int value();

    public SuitType suit() {
        return suitType;
    }

    /*
     * todo for future improvement
     * Check that card is available to be given out to someone
     */
    public boolean isAvailable() {
        return available;
    }

    public void markUnavailable() {
        available = false;
    }

    public void markAvailable() {
        available = true;
    }

    public void print() {
        String[] faceValues = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        System.out.print(faceValues[faceValue - 1] + " ");
        switch (suitType) {
            case Club -> System.out.print("Clubs");
            case Heart -> System.out.print("Hearts");
            case Diamond -> System.out.print("Diamonds");
            case Spade -> System.out.print("Spades");
        }
        System.out.print(" ");
    }

    @Override
    public String toString() {
        String[] faceValues = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        StringBuilder sb = new StringBuilder();
        sb.append(faceValues[faceValue - 1]);
        sb.append(" ");
        switch (suitType) {
            case Club -> sb.append("Clubs");
            case Heart -> sb.append("Hearts");
            case Diamond -> sb.append("Diamonds");
            case Spade -> sb.append("Spades");
        }
       return sb.toString();
    }
}
