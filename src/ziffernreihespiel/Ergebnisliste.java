package ziffernreihespiel;

import java.io.IOException;
import java.util.Scanner;

public class Ergebnisliste {
    private Ergebnis erstesErgebnis;

    public Ergebnisliste() {
        this.erstesErgebnis = null;
    }

    public void addErgebnis(String name, double spielzeit, int reihenlaenge, boolean roundWon) {
        Ergebnis neuesErgebnis = new ErgebnisImpl(name, spielzeit, reihenlaenge, roundWon);
        if (erstesErgebnis == null) {
            erstesErgebnis = neuesErgebnis;
        } else {
            Ergebnis aktuellesErgebnis = erstesErgebnis;
            while (aktuellesErgebnis.getNext() != null) {
                aktuellesErgebnis = aktuellesErgebnis.getNext();
            }
            aktuellesErgebnis.setNext(neuesErgebnis);
        }
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean weiterSpielen = true;
        int round = 1;

        while (weiterSpielen) {
            System.out.println("Willkommen zum Ziffernreihenspiel!");
            System.out.print("Bitte geben Sie Ihren Namen ein: ");
            String playerName = scanner.nextLine();

            System.out.print("Bitte geben Sie die Länge der Ziffernreihe ein: ");
            int sequenceLength = scanner.nextInt();

            Ziffernreihe sequence = generateZiffernreihe(sequenceLength);
            System.out.println("Die generierte Ziffernreihe lautet:");
            sequence.printZiffernreihe();

            System.out.println("Bitte vervollständigen Sie die Ziffernreihe:");
            long startTime = System.currentTimeMillis(); // Startzeit messen

            // Clear console after 1 second
            try {
                Thread.sleep(1000);
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (InterruptedException | IOException e) {
                System.out.println("Error clearing console: " + e.getMessage());
            }

            boolean roundWon = isSequenceCompleted(sequence, scanner);
            long endTime = System.currentTimeMillis(); // Endzeit messen
            double elapsedTime = (endTime - startTime) / 1000.0; // Umrechnen in Sekunden

            if (roundWon) {
                System.out.println("Herzlichen Glückwunsch! Sie haben die Ziffernreihe richtig vervollständigt.");
            } else {
                System.out.println("Leider haben Sie die Ziffernreihe falsch vervollständigt.");
            }
            System.out.println("Ihre Spielzeit beträgt: " + elapsedTime + " Sekunden.");

            addErgebnis(playerName, elapsedTime, sequenceLength, roundWon);
            System.out.println("Das Ergebnis wurde zur Ergebnisliste hinzugefügt.");

            System.out.println("\nAktualisierte Ergebnisliste nach Runde " + round + ":");
            printErgebnisliste();

            round++;
            System.out.print("\nMöchten Sie ein weiteres Spiel spielen? (ja/nein): ");
            String antwort = scanner.next();
            weiterSpielen = antwort.equalsIgnoreCase("ja");

            scanner.nextLine(); // Clear scanner buffer
        }

        scanner.close();
    }

    private Ziffernreihe generateZiffernreihe(int length) {
        Ziffernreihe sequence = new Ziffernreihe();
        for (int i = 0; i < length; i++) {
            sequence.append((int) (Math.random() * 10)); // Zufällige Ziffern hinzufügen (0-9)
        }
        return sequence;
    }

    private boolean isSequenceCompleted(Ziffernreihe sequence, Scanner scanner) {
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

    public void printErgebnisliste() {
        printErgebnislisteReversed(erstesErgebnis);
    }

    private void printErgebnislisteReversed(Ergebnis current) {
        if (current != null) {
            printErgebnislisteReversed(current.getNext());
            System.out.println(current.toString());
        }
    }

    private class ErgebnisImpl implements Ergebnis {
        private String name;
        private double spielzeit;
        private int laenge;
        private Ergebnis next;
        private boolean roundWon;

        public ErgebnisImpl(String name, double spielzeit, int laenge, boolean roundWon) {
            this.name = name;
            this.spielzeit = spielzeit;
            this.laenge = laenge;
            this.roundWon = roundWon;
        }

        @Override
        public String getNamedesSpielers() {
            return name;
        }

        @Override
        public String toString() {
            String result = name + ": Spielzeit - " + spielzeit + " Sekunden, Länge der Ziffernreihe - " + laenge
                    + ", Gewonnen - " + (roundWon ? "Ja" : "Nein");
            return result;
        }

        @Override
        public void setNamedesSpielers(String name) {
            this.name = name;
        }

        @Override
        public long getSpielzeit() {
            return (long) spielzeit;
        }

        @Override
        public void setStartzeit(long startzeit) {
            // Nicht benötigt für diese Implementierung
        }

        @Override
        public int getLaengeDerReihe() {
            return laenge;
        }

        @Override
        public void setLaengeDerReihe(int laenge) {
            this.laenge = laenge;
        }

        @Override
        public Ergebnis getNext() {
            return next;
        }

        @Override
        public void setNext(Ergebnis neuesErgebnis) {
            this.next = neuesErgebnis;
        }
    }
}
