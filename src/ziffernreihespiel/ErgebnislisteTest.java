package ziffernreihespiel;

public class ErgebnislisteTest {
    public static void main(String[] args) {
        // Erstellen einer Ergebnisliste und Hinzufügen von Ergebnissen
        Ergebnisliste ergebnisliste = new Ergebnisliste();
        ergebnisliste.addErgebnis("Spieler 1", 30.5, 10);
        ergebnisliste.addErgebnis("Spieler 2", 45.2, 15);
        ergebnisliste.addErgebnis("Spieler 3", 60.8, 20);

        // Ausgabe der Ergebnisliste
        System.out.println("Ergebnisliste:");
        ergebnisliste.printErgebnisliste();
    }
}
