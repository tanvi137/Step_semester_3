package week_1.class_problems;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    // Method to determine the winner of one round
    public static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        int rounds = 5;
        int wins = 0;
        int losses = 0;
        int draws = 0;

        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        // Play 5 rounds
        for (int i = 0; i < rounds; i++) {

            System.out.print("Round " + (i + 1) + " - Enter Rock, Paper, or Scissors: ");
            String playerMove = scanner.nextLine();

            // Format player's input
            playerMove = playerMove.substring(0, 1).toUpperCase()
                    + playerMove.substring(1).toLowerCase();

            // Generate computer's move randomly
            String computerMove = moves[random.nextInt(3)];

            // Determine result
            String result = playRound(playerMove, computerMove);

            // Store round details
            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            // Update scoreboard
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println("Computer: " + computerMove);
            System.out.println("Result: " + result);
            System.out.println();
        }

        // Calculate win percentage
        double winPercentage = ((double) wins / rounds) * 100;

        // Print summary table
        System.out.println("========== FINAL SUMMARY ==========");
        System.out.println("Round\tPlayer Move\tComputer Move\tResult");

        for (int i = 0; i < rounds; i++) {
            System.out.println(
                    (i + 1) + "\t" +
                    playerMoves[i] + "\t\t" +
                    computerMoves[i] + "\t\t" +
                    results[i]
            );
        }

        System.out.println("-----------------------------------");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%%n", winPercentage);

        scanner.close();
    }
}