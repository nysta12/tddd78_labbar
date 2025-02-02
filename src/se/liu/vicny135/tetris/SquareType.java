package se.liu.vicny135.tetris;

import java.util.Random;

public enum SquareType
{
    EMPTY, I, O, T, S, Z, J, L, OUTSIDE;

    public static void main(String[] args) {
        Random rnd = new Random();
        for (int i = 1; i <= 25; i++) {
            String str = ("%d: %s");
            int randomNumber = rnd.nextInt(SquareType.values().length);
            SquareType randomSquareType = SquareType.values()[randomNumber];
            //System.out.println(String.format(str, i, randomSquareType));
        }
    }
}