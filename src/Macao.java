import java.util.Scanner;

public class Macao {
    public static void main(String[] args){
        // Deklarationen
        Scanner scanner = new Scanner(System.in);
        final int numberOfPlayers;

        System.out.println("How many players?");
        numberOfPlayers = scanner.nextInt();

        // Scanner beenden
        scanner.close();
    }
}
