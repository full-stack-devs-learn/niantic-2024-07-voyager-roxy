package com.niantic.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Card implements Comparable<Card> {
    private String suit;
    private String faceValue;

    public Card(String suit, String faceValue) {
        this.suit = suit;
        this.faceValue = faceValue;
    }

    public String getSuit() {
        return suit;
    }

    public String getFaceValue() {
        return faceValue;
    }

    public int getPointValue() {
        return cardValues.get(faceValue);
    }

    public String getColor() {
        switch (suit.toLowerCase()) {
            case "hearts":
            case "diamonds":
                return "Red";
            default:
                return "Black";
        }
    }

    // lookup map
    private static final Map<String, Integer> cardValues = new HashMap<>() {{
        put("A", 11);
        put("K", 10);
        put("Q", 10);
        put("J", 10);
        put("10", 10);
        put("9", 9);
        put("8", 8);
        put("7", 7);
        put("6", 6);
        put("5", 5);
        put("4", 4);
        put("3", 3);
        put("2", 2);
    }};

    private static final Map<String, Integer> suitValues = new HashMap<>() {{
        put("Clubs", 1);
        put("Diamonds", 2);
        put("Hearts", 3);
        put("Spades", 4);
    }};

    private static final Map<String, Integer> faceValueOrder = new HashMap<>() {{
        put("10", 1);
        put("J", 2);
        put("Q", 3);
        put("K", 4);

    }};

    @Override
    public int compareTo(Card o) {
        // todo: Exercise 1: implement Comparable<Card>
        if (!o.getSuit().equals(this.getSuit())) {
            return suitValues.get(o.getSuit()) < suitValues.get(this.getSuit()) ? -1 : 1;
        }
        else {
            if (this.getPointValue() != o.getPointValue()) {
                return this.getPointValue() < o.getPointValue() ? -1 : 1;
            }
            else {
                return faceValueOrder.get(this.getFaceValue()) < faceValueOrder.get(o.getFaceValue()) ? -1 : 1;
            }
        }
    }
}
