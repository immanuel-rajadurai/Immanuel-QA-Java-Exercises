import java.util.Random;
import java.util.Scanner;

class Player {
    private int currentSum;
    private boolean bust;
    private boolean playing;

    public Player() {
        this.currentSum = 0;
        this.bust = false;
        this.playing = true;
    }

    // Method to add a card value to the current sum
    public void addCard(int cardValue) {
        currentSum += cardValue;
        checkIfOut();
    }

    // Method to check if the player is out (bust)
    private void checkIfOut() {
        if (currentSum > 21) {
            bust = true;
            playing = false; // Stop playing if busted
        }
    }

    // Getters for the player's state
    public int getCurrentSum() {
        return currentSum;
    }

    public boolean isBust() {
        return bust;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean val) {
        this.playing = val;
    }

    public void reset() {
        currentSum = 0;
        bust = false;
        playing = true;
    }
}

class BlackjackGame {
    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player[] players = new Player[3];

        // Instantiate 3 players
        for (int i = 0; i < 3; i++) {
            players[i] = new Player();
        }

        boolean gameOn = true;

        while (gameOn) {
            for (int i = 0; i < players.length; i++) {
                Player player = players[i];

                if (player.isPlaying()) {
                    // Show current sum
                    System.out.println("Player " + (i + 1) + " Current Sum: " + player.getCurrentSum());

                    // Ask player to stick or twist
                    System.out.print("Player " + (i + 1) + ", do you want to stick or twist? (s/t): ");
                    String action = scanner.nextLine();

                    if (action.equalsIgnoreCase("t")) {
                        // Player decides to twist (draw a card)
                        int cardValue = drawCard();
                        player.addCard(cardValue);
                        System.out.println("Player " + (i + 1) + " drew a card with value: " + cardValue);

                        // Check for bust
                        if (player.isBust()) {
                            System.out.println("Player " + (i + 1) + " is bust!");
                        }
                    } else if (action.equalsIgnoreCase("s")) {
                        // Player decides to stick
//                        player.reset(); // Reset for future games
                        player.setPlaying(false);
                        System.out.println("Player " + (i + 1) + " decided to stick.");
                    } else {
                        System.out.println("Invalid input. Please enter 's' to stick or 't' to twist.");
                    }
                }
            }

            // Check if all players are not playing
            gameOn = false;
            for (Player player : players) {
                if (player.isPlaying()) {
                    gameOn = true;
                    break;
                }
            }
        }

        int winnerNum = 0;
        int highest_score;
        highest_score = 0;

        for (int i = 0; i < players.length; i++) {
            Player player = players[i];
            if (player.getCurrentSum() > highest_score && !player.isBust()) {
                winnerNum = i+1;
                highest_score = player.getCurrentSum();
            }
        }

        System.out.println("Congrats " + winnerNum);
        System.out.println("Game Over!");
        scanner.close();
    }

    // Method to simulate drawing a card (1-11)
    private static int drawCard() {
        return random.nextInt(11) + 1; // Cards can have values from 1 to 11
    }
}