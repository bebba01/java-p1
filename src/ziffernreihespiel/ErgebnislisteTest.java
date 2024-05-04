package ziffernreihespiel;

import java.util.Scanner;

public class ErgebnislisteTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ergebnisliste ergebnisliste = new Ergebnisliste(); // Ergebnisliste erstellen
        int round = 1; // Initialize the round number

        while (true) {
            // Begrüßung und Eingabe des Spielernamens
            System.out.println("Willkommen zum Ziffernreihenspiel!");
            System.out.print("Bitte geben Sie Ihren Namen ein: ");
            String playerName = scanner.nextLine();

            // Eingabe der Länge der Ziffernreihe
            System.out.print("Bitte geben Sie die Länge der Ziffernreihe ein: ");
            int sequenceLength = scanner.nextInt();

            // Erzeugen einer Ziffernreihe und Anzeigen
            Ziffernreihe sequence = generateZiffernreihe(sequenceLength);
            System.out.println("Die generierte Ziffernreihe lautet:");
            sequence.printZiffernreihe();

            // Clear console after 1 second
            try {
                Thread.sleep(1000);
                System.out.print("\033[1A\033[K");
                // String os = System.getProperty("os.name").toLowerCase();
                // if (os.contains("windows")) {
                // new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                // } else {
                // new ProcessBuilder("clear").inheritIO().start().waitFor();
                // }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            // Spieler auffordern, die Ziffernreihe zu vervollständigen
            System.out.println("Bitte vervollständigen Sie die Ziffernreihe:");
            long startTime = System.currentTimeMillis(); // Startzeit messen
            boolean roundWon = isSequenceCompleted(sequence, scanner);
            long endTime = System.currentTimeMillis(); // Endzeit messen
            double elapsedTime = (endTime - startTime) / 1000.0; // Umrechnen in Sekunden

            // Anzeigen des Ergebnisses des aktuellen Durchgangs
            if (roundWon) {
                System.out.println("Herzlichen Glückwunsch! Sie haben die Ziffernreihe richtig vervollständigt.");
            } else {
                System.out.println("Leider haben Sie die Ziffernreihe falsch vervollständigt.");
            }
            System.out.println("Ihre Spielzeit beträgt: " + elapsedTime + " Sekunden.");

            // Hinzufügen des Ergebnisses zur Ergebnisliste
            ergebnisliste.addErgebnis(playerName, elapsedTime, sequenceLength, roundWon);
            System.out.println("Das Ergebnis wurde zur Ergebnisliste hinzugefügt.");

            // Anzeigen der aktualisierten Ergebnisliste
            System.out.println("\nAktualisierte Ergebnisliste nach Runde " + round + ":");
            ergebnisliste.printErgebnisliste();

            round++; // Increment the round number

            // Abfrage, ob der Spieler weiter spielen möchte
            System.out.print("\nMöchten Sie ein weiteres Spiel spielen? (ja/nein): ");
            String antwort = scanner.next();
            if (!antwort.equalsIgnoreCase("ja")) {
                break;
            }
            scanner.nextLine(); // Leeren des Scanners
        }

        scanner.close();
    }

    // Methode zum Generieren einer Ziffernreihe
    private static Ziffernreihe generateZiffernreihe(int length) {
        Ziffernreihe sequence = new Ziffernreihe();
        for (int i = 0; i < length; i++) {
            sequence.append((int) (Math.random() * 10)); // Zufällige Ziffern hinzufügen (0-9)
        }
        return sequence;
    }

    // Methode zum Überprüfen, ob die vom Benutzer eingegebene Sequenz korrekt ist
    private static boolean isSequenceCompleted(Ziffernreihe sequence, Scanner scanner) {
        Ziffernreihe.Node current = sequence.getKopf();
        while (current != null) {
            int expectedDigit = current.getData();
            System.out.print("Bitte geben Sie die nächste Ziffer ein: ");
            int userInput = scanner.nextInt();
            if (userInput != expectedDigit) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }
}
