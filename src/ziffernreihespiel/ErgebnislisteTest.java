package ziffernreihespiel;

import java.util.Scanner;

public class ErgebnislisteTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ergebnisliste ergebnisliste = new Ergebnisliste(); // Ergebnisliste erstellen
        ergebnisliste.playGame();

        scanner.close();
    }
}