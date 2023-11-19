import java.util.Scanner;

public class Macao {
    public static void main(String[] args){
        // Deklarationen
        Scanner scanner = new Scanner(System.in);
        final int numberOfPlayers;
        int currentScoreCount = 0;
        int randomValue;
        String userText;

        // Eigabe der Spieleranzahl
        System.out.println("How many players?");
        numberOfPlayers = scanner.nextInt();

        // Generiere eine Spielerliste
        String[] players = new String[numberOfPlayers];
        int[] playerScore = new int[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++){
            players[i] = "Player " + (i+1);
        }

        // Beginn des Spiels
        int counter = 0;
        for (String player : players) {
            System.out.println("NEXT TURN: " + player);
            do {
                randomValue = (int) ((Math.random()*10)%6)+1;
                currentScoreCount = currentScoreCount + randomValue;
                System.out.println("You rolled a " + randomValue + "! Score: " + currentScoreCount);
                if (currentScoreCount >= 9) {
                    break;
                }
                System.out.println("Roll the dice again? Press 'y' to continue or any other key to quit.");
                userText = scanner.next();
            }while (userText.equals("y"));

            if (currentScoreCount == 9) {
                System.out.println(player + " has won with a score of 9!");
                break;
            } else if (currentScoreCount > 9) {
                System.out.println("YOU LOSE!");
                currentScoreCount = 0;
            }
            playerScore[counter] = currentScoreCount;
            currentScoreCount = 0;

            // Ergebniss berechnen, falls kein Spieler direkt 9 wuerfelt
            if (player.equals("Player " + numberOfPlayers)) {

                // Berechnet das Gewinnerergebniss
                int winnerResult = 9;
                int winnerDiff = 9;

                for (int score : playerScore) {
                    int result = 9 - score;
                    if (result < winnerDiff) {
                        winnerDiff = result;
                        winnerResult = score;
                    }
                }

                // Berechnet wie oft und an welcher Stelle das gewinnerergebniss vorkommt
                int[] winnerList = new int[numberOfPlayers];
                int count = 0;
                int count2 = 0;
                for (int score : playerScore) {
                    if (score == winnerResult) {
                        winnerList[count2] = count;
                        count2++;
                    }
                    count++;
                }

                // System.out.println(Arrays.toString(winnerList));
                for (int winner : winnerList) {
                    if (winner == 0) {
                        continue;
                    }
                    System.out.println(players[winner] + " has won with a score of " + winnerResult + "!");
                }
            }
            counter++;
        }

        // Scanner beenden
        scanner.close();
    }
}
