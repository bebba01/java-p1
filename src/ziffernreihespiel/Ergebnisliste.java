package ziffernreihespiel;

/**
 * Diese Klasse repräsentiert eine Liste von Ergebnissen eines
 * Ziffernreihenspiels.
 */
public class Ergebnisliste {
    private Ergebnis erstesErgebnis;

    /**
     * Konstruktor für eine leere Ergebnisliste.
     */
    public Ergebnisliste() {
        this.erstesErgebnis = null;
    }

    /**
     * Fügt ein neues Ergebnis zur Ergebnisliste hinzu.
     * 
     * @param name         Der Name des Spielers.
     * @param spielzeit    Die Spielzeit in Sekunden.
     * @param reihenlaenge Die Länge der Ziffernreihe.
     */
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

    /**
     * Gibt die gespeicherten Ergebnisse der Ergebnisliste aus.
     */
    public void printErgebnisliste() {
        Ergebnis aktuellesErgebnis = erstesErgebnis;
        while (aktuellesErgebnis != null) {
            System.out.println(aktuellesErgebnis.toString());
            aktuellesErgebnis = aktuellesErgebnis.getNext();
        }
    }

    /**
     * Eine interne Implementierungsklasse für ein Ergebnis eines Spieldurchgangs.
     */
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
