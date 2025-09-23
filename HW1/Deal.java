import java.util.Scanner;

public class Deal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int PLAYERS = scanner.nextInt();

        int CARDS_PER_PLAYER = 5;
        String[] SUITS = {
                "Tep", "Ro", "Co", "Bich"
        };

        String[] RANKS = {
                "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "J", "Q", "K", "A"
        };

        int n = SUITS.length * RANKS.length;

        if (CARDS_PER_PLAYER * PLAYERS > n) {
            System.out.println("Too many players");
        PLAYER=0;
        }


        //Khoi tao bo bai
        String[] deck = new String[n];
        for (int i = 0; i < RANKS.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
                deck[SUITS.length*i + j] = RANKS[i]+ " "  + SUITS[j];
            }
        }

        // xao bai
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n-i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }

        // chia bai
        for (int i = 0; i < PLAYERS * CARDS_PER_PLAYER; i++) {
            System.out.println(deck[i]);
            if (i % CARDS_PER_PLAYER == CARDS_PER_PLAYER - 1)
                System.out.println();
        }
    }

}
